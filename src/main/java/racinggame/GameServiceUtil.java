package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class GameServiceUtil {
	public static List<CarName> askCarNames() {
		return askCarNameOnConsole();
	}

	private static List<CarName> askCarNameOnConsole() {
		String inputStrings = Console.readLine();
		try {
			return convertCarNames(inputStrings);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askCarNameOnConsole();
		}
	}

	static List<CarName> convertCarNames(String inputStrings) {
		String[] carNameStrings = inputStrings.split(",");
		List<CarName> carNames = new ArrayList<>();
		for (String carName : carNameStrings) {
			carNames.add(CarName.of(carName));
		}
		return carNames;
	}
}
