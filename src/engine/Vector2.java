package engine;

public class Vector2 {
	public double x;
	public double y;
	public Vector2(double x) {
		this.x = x;
		this.y = x;
	}
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Vector2 add(Vector2 other) {
		return new Vector2(x + other.x, y + other.y);
	}
	public double length() {
		/* Returns the length of the vector */
		return Math.sqrt(x*x + y*y);
	}
	public Vector2 mul(double v) {
		return new Vector2(x*v, y*v);
	}
 	public Vector2 normalized() {
		/* 
		 * returns a Vector2 with a length of 1 in the same direction as the original Vector 
		 * Returns a Vector2.ZERO if length is 0
		*/
		double vector_length = length();
		if (vector_length > 0) {
			return new Vector2(x/vector_length, y/vector_length);
		}
		return ZERO();
	}
	public static Vector2 ZERO() {
		return new Vector2(0);
	}
	public void display() {
		System.out.print((int) x);
		System.out.print(",");
		System.out.print((int) y);
	}
}
