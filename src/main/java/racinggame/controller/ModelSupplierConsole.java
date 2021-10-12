package racinggame.controller;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import racinggame.GameMessage;
import racinggame.model.CarName;
import racinggame.model.Turn;

public class ModelSupplierConsole implements ModelSupplier {

	public static final String CAR_NAME_SEPARATOR = ",";

	@Override
	public List<CarName> askCarNames() {
		System.out.println(String.format(GameMessage.ASK_CAR_NAME.getMessageForm(),
				ModelSupplierConsole.CAR_NAME_SEPARATOR));
		return askCarNameOnConsole();
	}

	private List<CarName> askCarNameOnConsole() {
		String inputStrings = Console.readLine();
		try {
			return convertCarNames(inputStrings);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askCarNameOnConsole();
		}
	}

	List<CarName> convertCarNames(String inputStrings) {
		String[] carNameStrings = inputStrings.split(CAR_NAME_SEPARATOR);
		List<CarName> carNames = new ArrayList<>();
		for (String carName : carNameStrings) {
			carNames.add(CarName.of(carName));
		}
		return carNames;
	}

	@Override
	public Turn askTurnNum() {
		System.out.println(GameMessage.ASK_TURN_NUM.getMessageForm());
		return askTurnNumByConsole();
	}

	private Turn askTurnNumByConsole() {
		String inputStrings = Console.readLine();
		try {
			return convertTurn(inputStrings);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askTurnNumByConsole();
		}
	}

	Turn convertTurn(String inputStrings) {
		try {
			int turnNum = Integer.parseInt(inputStrings);
			return Turn.of(turnNum);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(GameMessage.INVALID_INPUT_TURN_NUM.getMessageForm());
		}
	}
}
