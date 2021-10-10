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
		Turn turn = GameServiceUtil.askTurnNum();
	}
}
