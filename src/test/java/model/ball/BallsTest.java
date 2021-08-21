package model.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
    @DisplayName("Balls 객체를 받아 볼 카운트를 반환한다.")
    @MethodSource("provideBallNumbersForStrikeCount")
    void countSameNumberInSamePosition(int[] userBallNumbers, int[] systemBallNumbers, int expect) {
        Balls userBalls = new Balls(userBallNumbers);
        Balls systemBalls = new Balls(systemBallNumbers);
        int actual = userBalls.countSameNumberInSamePosition(systemBalls);
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBallNumbersForStrikeCount(){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 3),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}, 2),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 2}, 1),
                Arguments.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, 0)
        );
    }

    @ParameterizedTest
    @DisplayName("Balls 객체를 받아 볼 카운트를 반환한다.")
    @MethodSource("provideBallNumbersForBallCount")
    void countSameNumberInDifferentPosition(int[] userBallNumbers, int[] systemBallNumbers, int expect) {
        Balls userBalls = new Balls(userBallNumbers);
        Balls systemBalls = new Balls(systemBallNumbers);
        int actual = userBalls.countSameNumberInDifferentPosition(systemBalls);
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBallNumbersForBallCount(){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 1, 2}, 3),
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 1, 4}, 2),
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 5, 4}, 1),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 0)
        );
    }
}
