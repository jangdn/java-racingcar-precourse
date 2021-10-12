package racinggame.model;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.model.Car;
import racinggame.model.CarName;
import racinggame.model.CarValue;
import racinggame.model.Cars;

public class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car(CarName.of("소나타"));
	}

	@Test
	void input이_3이라면_멈춤() {
		int beforePosition = car.getPosition();

		car.run(CarValue.of(3));
		int afterPosition = car.getPosition();

		AssertionsForClassTypes.assertThat(afterPosition)
				.isEqualTo(beforePosition);
	}

	@Test
	void input이_4라면_전진() {
		int beforePosition = car.getPosition();

		car.run(CarValue.of(4));
		int afterPosition = car.getPosition();

		AssertionsForClassTypes.assertThat(afterPosition)
				.isGreaterThan(beforePosition);
	}

	@Test
	public void 한_턴_동안_3이하가_나온다면_자동차는_움직이지_않는다() {
		// given
		Cars firstClassCars = new Cars(Arrays.asList(car));
		int beforePosition = car.getPosition();

		// when
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(2);

			firstClassCars.eachRun();
		}

		// then
		int afterPosition = car.getPosition();
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
		List<Integer> beforePositions = Arrays.asList(firstCar.getPosition(),
				secondCar.getPosition(),
				thirdCar.getPosition());


		// when
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(2, 8, 9);

			firstClassCars.eachRun();
		}

		// then
		AssertionsForClassTypes.assertThat(firstCar.getPosition())
				.isEqualTo(beforePositions.get(0));
		AssertionsForClassTypes.assertThat(secondCar.getPosition())
				.isGreaterThan(beforePositions.get(1));
		AssertionsForClassTypes.assertThat(thirdCar.getPosition())
				.isGreaterThan(beforePositions.get(2));
	}

	@Test
	public void 가장_멀리_전진한_한대의_자동차를_뽑는다() {
		// given
		Car firstCar = new Car(CarName.of("첫번째차"));
		Car secondCar = new Car(CarName.of("두번째차"));
		Car thirdCar = new Car(CarName.of("세번째차"));
		Cars firstClassCars = new Cars(Arrays.asList(firstCar, secondCar, thirdCar));

		// when
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(2, 8, 9)
					.thenReturn(2, 8, 9)
					.thenReturn(2, 2, 9);
			for(int idx = 0; idx < 3; idx++) {
				firstClassCars.eachRun();
			}
		}

		// then
		WinnerCars winCars = firstClassCars.findWinnerCars();
		Assertions.assertThat(winCars.getCars())
				.isNotEmpty()
				.extracting(Car::getName)
				.startsWith("세번째차")
				.doesNotContainNull();
	}


	@Test
	public void 가장_멀리_전진한_자동차들_뽑는다() {
		// given
		Car firstCar = new Car(CarName.of("첫번째차"));
		Car secondCar = new Car(CarName.of("두번째차"));
		Car thirdCar = new Car(CarName.of("세번째차"));
		Cars firstClassCars = new Cars(Arrays.asList(firstCar, secondCar, thirdCar));

		// when
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(2, 8, 9)
					.thenReturn(2, 8, 9)
					.thenReturn(2, 8, 9);
			for(int idx = 0; idx < 3; idx++) {
				firstClassCars.eachRun();
			}
		}

		// then
		WinnerCars winCars = firstClassCars.findWinnerCars();
		Assertions.assertThat(winCars.getCars())
				.isNotEmpty()
				.extracting(Car::getName)
				.startsWith("두번째차")
				.doesNotContainNull()
				.containsSequence("세번째차");
	}
}
