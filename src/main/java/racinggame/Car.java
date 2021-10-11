package racinggame;

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

	public String getPositionState() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int state = 0; state < position.getValue(); state++) {
			stringBuilder.append(Position.PRINT_STATE);
		}
		return stringBuilder.toString();
	}

	public int getPosition() {
		return this.position.getValue();
	}

	public String getName() {
		return name.getName();
	}
}
