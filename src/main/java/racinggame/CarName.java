package racinggame;

public final class CarName {
	private String name;

	private CarName(String name) {
		this.name = name;
	}

	public static CarName of(String name) {
		if(name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름이 너무 깁니다");
		}

		return new CarName(name);
	}

	public String getName() {
		return name;
	}
}
