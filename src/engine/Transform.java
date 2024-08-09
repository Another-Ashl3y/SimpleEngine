package engine;

public class Transform {
	public Vector2 position;
	public Vector2 rotation;
	public Vector2 scale;
	public Transform(Vector2 position, Vector2 rotation, Vector2 scale) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}
	public static Transform DEFAULT() {
		return new Transform(Vector2.ZERO(), Vector2.ZERO(), new Vector2(1));
	}
}
