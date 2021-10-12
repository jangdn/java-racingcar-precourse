package racinggame.model;

public final class MoveRule {
	private static final int STANDARD_VALUE = 4;

	public static boolean isMovable(CarValue carValue) {
		return STANDARD_VALUE <= carValue.getValue();
	}
}
