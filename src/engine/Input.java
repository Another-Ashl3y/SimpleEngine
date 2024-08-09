package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Input implements KeyListener {
	
	public static Vector<Integer> pressedKeys = new Vector<>();

	@Override
	public void keyTyped(KeyEvent e) {} // Don't use

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (!is_pressed(code)) {
			pressedKeys.add(code);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		pressedKeys.removeElement(code);
	}
	
	public static boolean is_pressed(int e) {
		return (pressedKeys.contains(e));
	}
}
