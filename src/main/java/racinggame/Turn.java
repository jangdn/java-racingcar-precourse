package racinggame;

public class Turn {
	private int num;

	private Turn(int num) {
		this.num = num;
	}

	public static Turn of(int num) {
		return new Turn(num);
	}

	public int getNum() {
		return num;
	}
}
