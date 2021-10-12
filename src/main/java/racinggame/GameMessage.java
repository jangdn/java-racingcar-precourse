package racinggame;

public enum GameMessage {
	ASK_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)"),
	ASK_TURN_NUM("시도할 횟수는 몇회인가요?"),
	CAR_POSITION_STATE("%s : %s"),
	GAME_RESULT("최종 우승자는 %s 입니다."),

	INVALID_INPUT_CAR_NAME("[ERROR] 자동차 이름이 너무 깁니다"),
	INVALID_INPUT_TURN_NUM("[ERROR] 입력값에 숫자가 존재하지 않습니다."),

	CONSOLE_RESULT("실행 결과");

	private final String messageForm;

	GameMessage(String messageForm) {
		this.messageForm = messageForm;
	}

	public String getMessageForm() {
		return this.messageForm;
	}
}