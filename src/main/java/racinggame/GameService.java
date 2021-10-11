package racinggame;

import java.util.List;

public class GameService {
	private static class SingleGameService {
		private static final GameService gameService = new GameService();
	}

	public static GameService getInstance() {
		return SingleGameService.gameService;
	}

	public void play() {
		List<CarName> carNames = GameServiceUtil.askCarNames();
		Cars cars = Cars.createCars(carNames);

		Turn turn = GameServiceUtil.askTurnNum();

		for(int round = 0; turn.isProgressRound(round); round++) {
			cars.eachRun();
			cars.printCarState();
			System.out.println();
		}
	}
}
