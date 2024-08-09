package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

public class Node {
	public Transform transform = Transform.DEFAULT();
	public Transform globalTransform = Transform.DEFAULT();
	Vector<Node> children = new Vector<>();
	public void _ready() {}
	public void _process(long delta, Graphics g, Graphics2D graphics) {
//		_drawChildren(delta, g, graphics);
	}
	public void _physicsProcess(long delta) {}
	public void addChild(Node child) {
		children.add(child);
	}
//	public void _drawChildren(long delta, Graphics g, Graphics2D graphics) {
//		for (Node child: children) {
//			child._process(delta, g, graphics);
//		}
//	}
}
