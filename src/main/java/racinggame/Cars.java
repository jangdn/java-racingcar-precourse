package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private List<Car> values;

	public Cars(List<Car> values) {
		this.values = values;
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
}
