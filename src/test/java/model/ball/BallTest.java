package model.ball;

import model.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Ball userBall;

    @BeforeEach
    void setUp() {
        userBall = new Ball(1, 1);
    }

    @ParameterizedTest
    @DisplayName("Ball 객체를 받아 STRIKE, BALL, NOTHING 여부를 반환한다.")
    @CsvSource({"1, 1, STRIKE", "2, 1, BALL", "2, 2, NOTHING"})
    void isEqualNumberInSamePosition(final int position, final int number, final BallStatus expect) {
        BallStatus actual = userBall.compare(new Ball(position, number));
        assertThat(actual).isEqualTo(expect);
    }
}