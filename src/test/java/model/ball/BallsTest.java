package model.ball;

import model.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallsTest {
    @Test
    @DisplayName("중복이 있는 숫자를 가진 String[]을 받아 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByOverlap() {
        int[] numbers = {1, 1, 2};
        assertThatIllegalArgumentException().isThrownBy(() -> new Balls(numbers))
                .withMessage("숫자에 중복이 있습니다.");
    }

    @Test
    @DisplayName("잘못된 개수의 숫자를 가진 String[]을 받아 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByWrongNumberOfNumbers() {
        int[] numbers = {1, 2, 3, 4};
        assertThatIllegalArgumentException().isThrownBy(() -> new Balls(numbers))
                .withMessage("숫자의 개수가 잘못되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("Ball 객체를 받아 옳은 BallStatus를 반환한다")
    @CsvSource({"0, 3, STRIKE", "1, 3, BALL", "1, 9, NOTHING"})
    void compare(int ballPosition, int ballNumber, BallStatus expected) {
        Balls balls = new Balls(new int[]{3, 7, 8});
        Ball otherBall = new Ball(ballPosition, ballNumber);
        assertThat(balls.compare(otherBall)).isEqualTo(expected);
    }
}
