package racinggame;

public class Car {
	private Position position;
	private final String name;

	public Car(String name) {
		this.name = name;
		this.position = Position.initial();
	}

	public boolean move(CarValue carValue) {
		if (MoveRule.isMovable(carValue)) {
			this.position.moveForward();
			return true;
		}
		return false;
	}

	public Position getPosition() {
		return this.position;
	}
}
