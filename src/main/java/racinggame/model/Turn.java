package racinggame.model;

import racinggame.GameMessage;

public final class Turn {
	private final int num;

	private Turn(int num) {
		this.num = num;
	}

	public static Turn of(int num) {
		if (num < 0) {
			throw new IllegalArgumentException(GameMessage.INVALID_INPUT_TURN_NUM_MINUS.getMessageForm());
		}
		return new Turn(num);
	}

	public int getNum() {
		return num;
	}

	public boolean isProgressRound(int round) {
		return this.num > round;
	}
}
