package racinggame;

public final class CarName {
	private String name;

	private CarName(String name) {
		this.name = name;
	}

	public static CarName of(String name) {
		if(name.length() > 5) {
			throw new IllegalArgumentException(GameMessage.INVALID_INPUT_CAR_NAME.getMessageForm());
		}

		return new CarName(name);
	}

	public String getName() {
		return name;
	}
}
