package racinggame.view;

import java.util.ArrayList;
import java.util.List;

import racinggame.GameMessage;
import racinggame.model.Car;
import racinggame.model.WinnerCars;

public class WinnerCarsView {

	private static final String WINNER_CAR_DELIMITER = ",";

	public static void printWinner(WinnerCars winnerCars) {
		System.out.println(String.format(GameMessage.GAME_RESULT.getMessageForm(),
				getCarNames(winnerCars.getCars())));
	}

	private static String getCarNames(List<Car> cars) {
		List<String> carNames = new ArrayList<>();
		for (Car car : cars) {
			carNames.add(car.getName());
		}
		return String.join(WINNER_CAR_DELIMITER, carNames);
	}
}
