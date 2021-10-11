package racinggame;

public enum GameMessage {
	CAR_POSITION_STATE("%s: %s"),

	INVALID_INPUT_STRING("[ERROR] 잘못된 입력값입니다."),

	CONSOLE_RESULT("실행 결과");

	private final String messageForm;

	GameMessage(String messageForm) {
		this.messageForm = messageForm;
	}

	public String getMessageForm() {
		return this.messageForm;
	}
}