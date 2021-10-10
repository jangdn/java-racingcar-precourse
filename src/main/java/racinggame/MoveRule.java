package racinggame;

public class MoveRule {
	private static final int STANDARD_VALUE = 4;

	public static boolean isMovable(int no) {
		return STANDARD_VALUE <= no;
	}
}
