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
		System.out.println(String.format(GameMessage.ASK_CAR_NAME.getMessageForm(), GameServiceUtil.CAR_NAME_SEPARATOR));
		List<CarName> carNames = GameServiceUtil.askCarNames();
		Cars cars = Cars.createCars(carNames);

		System.out.println(GameMessage.ASK_TURN_NUM.getMessageForm());
		Turn turn = GameServiceUtil.askTurnNum();
		System.out.println();

		System.out.println(GameMessage.CONSOLE_RESULT.getMessageForm());
		for(int round = 0; turn.isProgressRound(round); round++) {
			cars.eachRun();
			cars.printCarState();
			System.out.println();
		}

		List<Car> farthestCars = cars.findFarthestCars();
		System.out.println(String.format(GameMessage.GAME_RESULT.getMessageForm(), CarNameUtil.from(farthestCars)));
	}
}
