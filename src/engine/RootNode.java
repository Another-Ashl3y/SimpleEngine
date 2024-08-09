package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

public class RootNode extends Node {
	public void ready() {
		for (Node node: children) {
			readyNode(node);
		}
	}
	public void readyNode(Node node) {
		node._ready();
		for (Node child: node.children) {
			readyNode(child);
		}
	}
	public void update(long physics_delta) {
		for (Node node: children) {
			node.globalTransform.position = node.transform.position.add(transform.position);
			updateNode(node, physics_delta);
		}
	}
	public void updateNode(Node node, long physics_delta) {
		node._physicsProcess(physics_delta);
		for (Node child: node.children) {
			child.globalTransform.position = node.globalTransform.position.add(child.transform.position);
			updateNode(child, physics_delta);
		}
	}
	public void paint(Graphics g, Graphics2D graphics, long delta) {
		for (Node node: children) {
			paintNode(node, g, graphics, delta);
		}
	}
	public void paintNode(Node node, Graphics g, Graphics2D graphics, long delta) {
		node._process(delta, g, graphics);
		for (Node child: node.children) {
			node.globalTransform.position.display();
			System.out.print(" ");
			child.globalTransform.position.display();
			System.out.print("\n");
			paintNode(child, g, graphics, delta);
		}
	}
}
