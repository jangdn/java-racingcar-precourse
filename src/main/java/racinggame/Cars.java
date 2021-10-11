package racinggame;

import static racinggame.GameMessage.CAR_POSITION_STATE;

import java.util.ArrayList;
import java.util.List;

public final class Cars {

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

	public void printCarState() {
		for (Car car : values) {
			System.out.println(String.format(CAR_POSITION_STATE.getMessageForm(),
					car.getName(),
					car.getPositionState()));
		}
	}
}
