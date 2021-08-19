package model.ball;

import model.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("같은 값과 다른 위치의 Ball객체를 받아 BallStatus.BALL을 반환한다")
    @CsvSource({"1, 1, STRIKE", "2, 1, BALL", "2, 2, NOTHING"})
    void compare_Ball(int ballPosition, int ballNumber, BallStatus expect) {
        BallStatus actual = userBall.compare(new Ball(ballPosition, ballNumber));
        assertThat(actual).isEqualTo(expect);
    }
}
