package racinggame.model;

public final class Position {
	private int value;

	private Position(int value) {
		this.value = value;
	}

	public static Position initial() {
		return new Position(0);
	}

	public void moveForward() {
		this.value++;
	}

	public int getValue() {
		return value;
	}
}
