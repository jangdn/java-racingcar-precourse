package racinggame.controller;

import racinggame.GameMessage;
import racinggame.model.Cars;
import racinggame.model.Turn;
import racinggame.model.WinnerCars;
import racinggame.view.CarsView;
import racinggame.view.WinnerCarsView;

public class GameController {
	private final ModelSupplier modelSupplier;

	private GameController(ModelSupplier modelSupplier) {
		this.modelSupplier = modelSupplier;
	}

	private static class SingleGameService {
		private static final GameController GAME_CONTROLLER = new GameController(new ModelSupplierConsole());
	}

	public static GameController getInstance() {
		return SingleGameService.GAME_CONTROLLER;
	}

	public void play() {
		Cars cars = Cars.createCars(modelSupplier.askCarNames());
		Turn turn = modelSupplier.askTurnNum();

		execute(cars, turn);

		WinnerCars winnerCars = cars.findWinnerCars();
		WinnerCarsView.printWinner(winnerCars);
	}

	private void execute(Cars cars, Turn turn) {
		System.out.println(GameMessage.CONSOLE_RESULT.getMessageForm());
		for(int round = 0; turn.isProgressRound(round); round++) {
			cars.eachRun();
			CarsView.printCurrentState(cars);
			System.out.println();
		}
	}
}
