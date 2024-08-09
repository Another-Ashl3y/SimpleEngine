package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.Player;

public class Manager extends JPanel implements Runnable {
	
	private static final long serialVersionUID = -258686108424137522L;
	
	Thread gameThread;
	RootNode root = new RootNode();;
	Input keyH = new Input();

	public static int WINDOW_WIDTH = 160*4;
	public static int WINDOW_HEIGHT = 90*4;
	
	
	long delta;
	long physics_delta;
	int FPS = 60;
	long timeOfDraw;
	long timeOfUpdate;
	
	public Manager() {
		this.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void addNode(Node node) {
		root.addChild(node);
	}
	
	public void start() {
		root.ready();
		
		startGameThread();
		
		timeOfDraw = System.currentTimeMillis();
		timeOfUpdate = System.currentTimeMillis();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		while (gameThread != null) {
			long currentTime = System.currentTimeMillis();
			physics_delta = currentTime - timeOfUpdate;
			delta = currentTime - timeOfDraw;
			
			update();
			timeOfUpdate = currentTime;
			
//			if (delta > 0) {
				// Only draw when needed
//				if (delta > 1/FPS) {
					repaint();
					timeOfDraw = currentTime;
//				}
//			}
		}
	}
	
	public void update() {
		root.update(physics_delta);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D)g;
		root.paint(g, graphics, delta); // Paint all components
		graphics.dispose();
	}

}
