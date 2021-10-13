package racinggame.model;

import java.util.List;

public class WinnerCars {
	private final List<Car> cars;

	public WinnerCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
