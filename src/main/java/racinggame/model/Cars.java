package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public final class Cars {
	private final List<Car> values;

	public Cars(List<Car> values) {
		this.values = values;
	}

	public List<Car> getValue() {
		return this.values;
	}

	public static Cars createCars(List<CarName> carNames) {
		List<Car> cars = new ArrayList<>();
		for (CarName carName : carNames) {
			cars.add(new Car(carName));
		}
		return new Cars(cars);
	}

	public void eachRun() {
		for (Car car : values) {
			CarValue carValue = CarValue.createValue();
			car.run(carValue);
		}
	}

	public WinnerCars findWinnerCars() {
		List<Car> winnerCars = new ArrayList<>();
		int maxPosition = 0;
		for (Car car : values) {
			maxPosition = judgeFarthestCar(winnerCars, maxPosition, car);
		}
		return new WinnerCars(winnerCars);
	}

	private int judgeFarthestCar(List<Car> winnerCars, int maxPosition, Car car) {
		if(car.getPosition() > maxPosition) {
			winnerCars.clear();
			winnerCars.add(car);
			return car.getPosition();
		}
		if(car.getPosition() == maxPosition) {
			winnerCars.add(car);
		}
		return maxPosition;
	}
}
