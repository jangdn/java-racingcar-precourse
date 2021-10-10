package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car ("sonata");
	}

	@Test
	void input이_3이라면_멈춤() {
		int beforePosition =  car.getPosition().getValue();

		car.run(3);
		int afterPosition = car.getPosition().getValue();

		assertThat(afterPosition)
				.isEqualTo(beforePosition);
	}

	@Test
	void input이_4라면_전진() {
		int beforePosition = car.getPosition().getValue();

		car.run(4);
		int afterPosition = car.getPosition().getValue();

		assertThat(afterPosition)
				.isGreaterThan(beforePosition);
	}

}
