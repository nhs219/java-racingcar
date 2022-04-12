package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new NormalStrategy());
    }

    @Test
    public void 전진테스트() {
        assertThat(car.move(4)).isEqualTo("-");
        assertThat(car.move(6)).isEqualTo("-");
        assertThat(car.move(8)).isEqualTo("-");
    }

    @Test
    public void 정지테스트() {
        assertThat(car.move(3)).isEqualTo("");
        assertThat(car.move(2)).isEqualTo("");
        assertThat(car.move(0)).isEqualTo("");
    }

    @Test
    public void 움직인거리누적_테스트() {
        car.move(4);
        car.move(6);
        car.move(8);

        assertThat(car.getDistance()).isEqualTo("---");

        car.move(2);

        assertThat(car.getDistance()).isEqualTo("---");

        car.move(9);

        assertThat(car.getDistance()).isEqualTo("----");

    }

    @Test
    public void 랜덤값_테스트() {
        for (int i = 0; i < 100; ++i) {
            assertThat(CarStadium.extractRandomNumber())
                    .isGreaterThan(-1)
                    .isLessThan(10);
        }
    }

    @Test
    public void 자동차_전진테스트() {
        for (int i = 0; i < 100; ++i) {
            int result = CarStadium.extractRandomNumber();
            assertThat(car.move(result)).isIn("-", "");
        }
    }
}