package racinggame;

public class Car {
	private Position position;
	private CarName name;

	public Car(CarName name) {
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
