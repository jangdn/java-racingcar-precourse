package racinggame.model;

public class Car {
	private Position position;
	private CarName name;

	public Car(CarName name) {
		this.name = name;
		this.position = Position.initial();
	}

	public void run(CarValue carValue) {
		if (MoveRule.isMovable(carValue)) {
			this.position.moveForward();
		}
	}

	public int getPosition() {
		return this.position.getValue();
	}

	public String getName() {
		return name.getName();
	}
}
