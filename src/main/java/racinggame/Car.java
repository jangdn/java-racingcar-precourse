package racinggame;

public class Car {
	private final String name;
	private Position position;

	public Car(String name) {
		this.name = name;
		this.position = Position.initial();
	}

	public void run(int no) {
		if (MoveRule.isMovable(no)) {
			this.position.moveForward();
		}
	}

	public Position getPosition() {
		return this.position;
	}
}
