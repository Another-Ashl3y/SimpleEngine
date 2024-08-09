package main;

import engine.Game;
import engine.Manager;
import engine.Sprite;

public class Main {

	public static void main(String[] args) {
		Player player = new Player();
		player.addChild(new Sprite("/player.png"));
		
		Manager manager = new Manager();
		manager.addNode(player);
		
		Game game = new Game("Simple game", false, manager);
		
		game.start();
	}
}
