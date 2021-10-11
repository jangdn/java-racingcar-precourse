package racinggame;


public final class Position {
	private int value;

	private Position(int value) {
		this.value = value;
	}

	public static Position create(int value) {
		return new Position(value);
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
