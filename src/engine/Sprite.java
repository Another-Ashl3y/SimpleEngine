package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite extends Node {
	public BufferedImage image;
	public Sprite(String path) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void _process(long delta, Graphics g, Graphics2D graphics) {
		System.out.println("Sprite Drawn");
		graphics.drawImage(
				image, 
				(int) transform.position.x, 
					(int) transform.position.y,
				(int) (image.getWidth() * transform.scale.x), 
					(int) (image.getHeight() * transform.scale.y), 
				null
			);
	}
}
