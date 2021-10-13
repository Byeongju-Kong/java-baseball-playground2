package model.ball;

import model.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
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
    @DisplayName("Balls 객체를 받아 BallStatus들을 반환한다.")
    @MethodSource("provideBaseballsAndBallStatuses")
    void compare(final int[] inputBalls, final int[] randomBalls, final List<BallStatus> expect) {
        Balls userBalls = new Balls(inputBalls);
        Balls systemBalls = new Balls(randomBalls);
        assertThat(userBalls.compare(systemBalls)).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBaseballsAndBallStatuses() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3},
                        Arrays.asList(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.STRIKE)),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4},
                        Arrays.asList(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.NOTHING)),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 1},
                        Arrays.asList(BallStatus.BALL, BallStatus.STRIKE, BallStatus.BALL)),
                Arguments.of(new int[]{1, 2, 3}, new int[]{4, 5, 6},
                        Arrays.asList(BallStatus.NOTHING, BallStatus.NOTHING, BallStatus.NOTHING))
        );
    }
}
