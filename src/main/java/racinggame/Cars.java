package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	private List<Car> values;

	public Cars(List<Car> values) {
		this.values = values;
	}

	public List<Boolean> eachRun() {
		List<Boolean> isMoveCars = new ArrayList<>();
		for (Car value : values) {
			CarValue carValue = CarValue.createValue();
			Car car = value;
			isMoveCars.add(car.move(carValue));
		}
		return isMoveCars;
	}
}
