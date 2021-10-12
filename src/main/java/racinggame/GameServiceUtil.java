package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class GameServiceUtil {

	public static final String CAR_NAME_SEPARATOR = ",";

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
		String[] carNameStrings = inputStrings.split(CAR_NAME_SEPARATOR);
		List<CarName> carNames = new ArrayList<>();
		for (String carName : carNameStrings) {
			carNames.add(CarName.of(carName));
		}
		return carNames;
	}

	public static Turn askTurnNum() {
		return askTurnNumByConsole();
	}

	private static Turn askTurnNumByConsole() {
		String inputStrings = Console.readLine();
		try {
			return convertTurn(inputStrings);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askTurnNumByConsole();
		}
	}

	static Turn convertTurn(String inputStrings) {
		try {
			int turnNum = Integer.parseInt(inputStrings);
			return Turn.of(turnNum);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(GameMessage.INVALID_INPUT_TURN_NUM.getMessageForm());
		}
	}
}
