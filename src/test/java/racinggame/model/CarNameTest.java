package racinggame.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CarNameTest {
	@Test
	public void 차_이름이_5자_이상_시_ERROR_로_시작하는_Exception() {
		// when
		Exception exception =
				assertThrows(IllegalArgumentException.class, () -> CarName.of("나는5자이상"));

		// then
		assertTrue(exception.getMessage().contains("ERROR"));
	}

}