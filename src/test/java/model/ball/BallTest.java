package model.ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Ball userBall;

    @BeforeEach
    void setUp() {
        userBall = new Ball(1, 1);
    }

    @Test
    @DisplayName("같은 값과 같은 위치의 Ball객체를 받아 true을 반환한다")
    void isEqualNumberInSamePosition() {
        boolean actual = userBall.isEqualNumberInSamePosition(new Ball(1, 1));
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("같은 값과 다른 위치의 Ball객체를 받아 true을 반환한다")
    void isEqualNumberInDifferentPosition() {
        boolean actual = userBall.isEqualNumberInDifferentPosition((new Ball(2, 1)));
        assertThat(actual).isTrue();
    }
}
