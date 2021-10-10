package racinggame;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("sonata");
	}

	@Test
	void input이_3이라면_멈춤() {
		int beforePosition = car.getPosition().getValue();

		boolean isMove = car.move(CarValue.of(3));
		int afterPosition = car.getPosition().getValue();

		AssertionsForClassTypes.assertThat(isMove).isFalse();
		AssertionsForClassTypes.assertThat(afterPosition)
				.isEqualTo(beforePosition);
	}

	@Test
	void input이_4라면_전진() {
		int beforePosition = car.getPosition().getValue();

		boolean isMove = car.move(CarValue.of(4));
		int afterPosition = car.getPosition().getValue();

		AssertionsForClassTypes.assertThat(isMove).isTrue();
		AssertionsForClassTypes.assertThat(afterPosition)
				.isGreaterThan(beforePosition);
	}

	@Test
	public void 한_턴_동안_3이하가_나온다면_자동차는_움직이지_않는다() {
		// given
		Car firstCar = new Car("첫번째차");
		Cars firstClassCars = new Cars(Arrays.asList(firstCar));
		List<Boolean> eachCarIsMoves;

		// when
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(2);

			eachCarIsMoves = firstClassCars.eachRun();
		}

		// then
		Assertions.assertThat(eachCarIsMoves)
				.isNotEmpty()
				.startsWith(false)
				.doesNotContainNull();
	}

	@Test
	public void 한_턴_동안_여러대의차는_조건에따라_움직이거나_멈춰야한다() {
		// given
		Car firstCar = new Car("첫번째차");
		Car secondCar = new Car("두번째차");
		Car thirdCar = new Car("세번째차");
		Cars firstClassCars = new Cars(Arrays.asList(firstCar, secondCar, thirdCar));
		List<Boolean> eachCarIsMoves;

		// when
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(2, 8, 9);

			eachCarIsMoves = firstClassCars.eachRun();
		}

		// then
		Assertions.assertThat(eachCarIsMoves)
				.isNotEmpty()
				.startsWith(false)
				.doesNotContainNull()
				.containsSequence(true, true);
	}

}
