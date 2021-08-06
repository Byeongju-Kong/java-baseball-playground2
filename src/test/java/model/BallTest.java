package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Ball userBall;

    @BeforeEach
    void setUp() {
        userBall = new Ball(1, new BaseballNumber(1));
    }

    @Test
    @DisplayName("같은 값과 다른 위치의 Ball객체를 받아 BallStatus.BALL을 반환한다")
    void check_Ball() {
        assertThat(userBall.check(new Ball(2, new BaseballNumber(1)))).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("같은 값과 같은 위치의 Ball객체를 받아 BallStatus.STRIKE를 반환한다")
    void check_Strike() {
        assertThat(userBall.check(new Ball(1, new BaseballNumber(1)))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("다른 값과 다른 위치의 Ball객체를 받아 BallStatus.NOTHING을 반환한다")
    void check_Nothing() {
        assertThat(userBall.check(new Ball(2, new BaseballNumber(2)))).isEqualTo(BallStatus.NOTHING);
    }
}
