package racinggame;

import java.util.ArrayList;
import java.util.List;

public class CarNameUtil {
	public static String from(List<Car> cars) {
		List<String> carNames = new ArrayList<>();
		for (Car car : cars) {
			carNames.add(car.getName());
		}
		return String.join(",", carNames);
	}
}
