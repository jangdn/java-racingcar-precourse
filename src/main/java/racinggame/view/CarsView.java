package racinggame.view;

import static racinggame.GameMessage.CAR_CURRENT_STATE;

import racinggame.model.Car;
import racinggame.model.Cars;

public class CarsView {
	public static void printCurrentState(Cars cars) {
		for (Car car : cars.getValue()) {
			System.out.println(String.format(CAR_CURRENT_STATE.getMessageForm(),
					car.getName(),
					PositionView.getCurrentPositionState(car.getPosition())));
		}
	}
}
