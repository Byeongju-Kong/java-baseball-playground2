package model.ball;

import model.BallStatus;
import model.ball.Ball;
import model.ball.Balls;
import model.ball.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BallsTest {
    private model.ball.Balls Balls;

    @Test
    @DisplayName("중복이 있는 숫자를 가진 String[]을 받아 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByOverlap() {
        assertThatThrownBy(() -> new Balls(new String[]{"1", "1", "2"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자에 중복이 있습니다.");
    }

    @Test
    @DisplayName("잘못된 개수의 숫자를 가진 String[]을 받아 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByWrongNumberOfNumbers() {
        assertThatThrownBy(() -> new Balls(new String[]{"1", "2", "3", "4"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 개수가 잘못되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("Ball 객체를 받아 옳은 BallStatus를 반환한다")
    @MethodSource("provideBallAndBallStatus")
    void compare(Ball ball, BallStatus expected) {
        Balls balls = new Balls(new String[]{"3", "7", "8"});
        assertThat(balls.compare(ball)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBallAndBallStatus() {
        return Stream.of(
                Arguments.of(new Ball(0, new BaseballNumber(3)),BallStatus.STRIKE),
                Arguments.of(new Ball(1, new BaseballNumber(3)), BallStatus.BALL),
                Arguments.of(new Ball(1, new BaseballNumber(4)), BallStatus.NOTHING)
        );
    }
}
