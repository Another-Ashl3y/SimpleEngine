package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import engine.Input;
import engine.Manager;
import engine.Node;
import engine.Vector2;

public class Player extends Node {
	
	double speed = 0.5;
	Vector2 velocity = Vector2.ZERO();
	
	public Player() {
		this.transform.position.x = Manager.WINDOW_WIDTH/2;
		this.transform.position.y = Manager.WINDOW_HEIGHT/2;
	}
	
	public void _physicsProcess(long delta) {
		handle_input(delta);
		transform.position = transform.position.add(velocity);
	}
	
	public void handle_input(long delta) {
		Vector2 direction = Vector2.ZERO();
		if (Input.is_pressed(KeyEvent.VK_W)) {
			direction.y -= 1;
		}
		if (Input.is_pressed(KeyEvent.VK_S)) {
			direction.y += 1;
		}
		if (Input.is_pressed(KeyEvent.VK_A)) {
			direction.x -= 1;
		}
		if (Input.is_pressed(KeyEvent.VK_D)) {
			direction.x += 1;
		}
		velocity = direction.normalized().mul(speed*delta);
	}
	
	public void _process(long delta, Graphics g, Graphics2D graphics) {
//		System.out.println("Player drawn");
		graphics.setColor(Color.WHITE);
		graphics.fillRect((int) globalTransform.position.x, (int) globalTransform.position.y, 10, 10);
	}
}
