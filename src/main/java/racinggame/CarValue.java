package racinggame;

import nextstep.utils.Randoms;

public class CarValue {
	private static final int RESTRICT_END_NUM = 9;
	private static final int RESTRICT_START_NUM = 0;

	private int value;

	private CarValue(int value) {
		this.value = value;
	}

	public static CarValue of(int value) {
		return new CarValue(value);
	}

	public static CarValue createValue() {
		return new CarValue(Randoms.pickNumberInRange(RESTRICT_START_NUM, RESTRICT_END_NUM));
	}

	public int getValue() {
		return value;
	}
}
