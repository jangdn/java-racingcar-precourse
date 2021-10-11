package racinggame;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.*;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car(CarName.of("소나타"));
	}

	@Test
	void input이_3이라면_멈춤() {
		int beforePosition = car.getPosition().getValue();

		car.run(CarValue.of(3));
		int afterPosition = car.getPosition().getValue();

		AssertionsForClassTypes.assertThat(afterPosition)
				.isEqualTo(beforePosition);
	}

	@Test
	void input이_4라면_전진() {
		int beforePosition = car.getPosition().getValue();

		car.run(CarValue.of(4));
		int afterPosition = car.getPosition().getValue();

		AssertionsForClassTypes.assertThat(afterPosition)
				.isGreaterThan(beforePosition);
	}

	@Test
	public void 한_턴_동안_3이하가_나온다면_자동차는_움직이지_않는다() {
		// given
		Cars firstClassCars = new Cars(Arrays.asList(car));
		int beforePosition = car.getPosition().getValue();

		// when
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(2);

			firstClassCars.eachRun();
		}

		// then
		int afterPosition = car.getPosition().getValue();
		AssertionsForClassTypes.assertThat(afterPosition)
				.isEqualTo(beforePosition);
	}

	@Test
	public void 한_턴_동안_여러대의차는_조건에따라_움직이거나_멈춰야한다() {
		// given
		Car firstCar = new Car(CarName.of("첫번째차"));
		Car secondCar = new Car(CarName.of("두번째차"));
		Car thirdCar = new Car(CarName.of("세번째차"));
		Cars firstClassCars = new Cars(Arrays.asList(firstCar, secondCar, thirdCar));
		List<Integer> beforePositions = Arrays.asList(firstCar.getPosition().getValue(),
				secondCar.getPosition().getValue(),
				thirdCar.getPosition().getValue());


		// when
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(2, 8, 9);

			firstClassCars.eachRun();
		}

		// then
		AssertionsForClassTypes.assertThat(firstCar.getPosition().getValue())
				.isEqualTo(beforePositions.get(0));
		AssertionsForClassTypes.assertThat(secondCar.getPosition().getValue())
				.isGreaterThan(beforePositions.get(1));
		AssertionsForClassTypes.assertThat(thirdCar.getPosition().getValue())
				.isGreaterThan(beforePositions.get(2));
	}
}
