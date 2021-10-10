package racinggame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameServiceUtilTest {

	@Test
	public void 콤마로_구분된_문자열을_이름으로_바꿔준다() {
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
	public void 콤마로_구분된_문자열중_6자_이상의_문자가_있다면_exception() {
		// given
		String inputStr = "아반떼,쏘나타,그렌져랍니다";

		// when
		Exception exception =
				assertThrows(IllegalArgumentException.class, () -> GameServiceUtil.convertCarNames(inputStr));

		// then
		assertTrue(exception.getMessage().contains("ERROR"));
	}

}