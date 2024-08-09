package engine;

import javax.swing.JFrame;

public class Game {

	JFrame window = new JFrame();
	
	
	Manager manager;
	
	
	public Game(String title, boolean resizable, Manager manager) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(resizable);
		window.setTitle(title);

		this.manager = manager;
		window.add(this.manager);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

	public void start() {
		manager.start();
	}
}
