package racinggame.view;

public class PositionView {
	public static final String PRINT_STATE = "-";

	public static String getCurrentPositionState(int position) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int state = 0; state < position; state++) {
			stringBuilder.append(PRINT_STATE);
		}
		return stringBuilder.toString();
	}
}