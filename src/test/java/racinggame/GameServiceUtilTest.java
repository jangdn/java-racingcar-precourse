package racinggame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameServiceUtilTest {

	@Test
	public void askCarNames_콤마로_구분된_문자열을_이름으로_바꿔준다() {
		// given
		String inputStr = "아반떼,쏘나타,그렌져";

		// when
		List<CarName> carNames = GameServiceUtil.convertCarNames(inputStr);

		// then
		Assertions.assertThat(carNames)
				.isNotEmpty()
				.extracting(CarName::getName)
				.startsWith("아반떼")
				.doesNotContainNull()
				.containsSequence("쏘나타", "그렌져");
	}

	@Test
	public void askCarNames_콤마로_구분된_문자열중_6자_이상의_문자가_있다면_exception() {
		// given
		String inputStr = "아반떼,쏘나타,그렌져랍니다";

		// when
		Exception exception =
				assertThrows(IllegalArgumentException.class, () -> GameServiceUtil.convertCarNames(inputStr));

		// then
		assertTrue(exception.getMessage().contains("ERROR"));
	}

	@Test
	public void askTurnNum_숫자의_입력값을_Turn으로_변환한다() {
		// given
		String inputStr = "1";

		// when
		Turn turn = GameServiceUtil.convertTurn(inputStr);

		// then
		assertEquals(turn.getNum(), 1);
	}

	@Test
	public void askTurnNum_숫자의_입력값에_숫자값이_없을경우_exception() {
		// given
		String inputStr = "asdfekw";

		// when
		Exception exception =
				assertThrows(IllegalArgumentException.class, () -> GameServiceUtil.convertTurn(inputStr));

		// then
		assertTrue(exception.getMessage().contains("ERROR"));
	}
}