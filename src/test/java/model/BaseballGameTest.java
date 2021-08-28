package model;

import model.ball.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {
    private BaseballGame baseballGame;

    @ParameterizedTest
    @DisplayName("두 야구게임 숫자를 받아, Count객체를 받아 StrikeCount를 얻는다.")
    @MethodSource("provideBallsAndStrikeCount")
    void getCount_Strike(int[] userNumbers, List<Ball> systemNumbers, int expect) {
        baseballGame = new BaseballGame(userNumbers, systemNumbers);
        int actual = baseballGame.getCount().getStrike();
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBallsAndStrikeCount() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 1), new Ball(1, 2), new Ball(2, 3)), 3),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 1), new Ball(1, 2), new Ball(2, 4)), 2),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 1), new Ball(1, 4), new Ball(2, 5)), 1),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 4), new Ball(1, 5), new Ball(2, 6)), 0)
                );
    }

    @ParameterizedTest
    @DisplayName("두 야구게임 숫자를 받아, Count객체를 받아 BallCount를 얻는다.")
    @MethodSource("provideBallsAndBallCount")
    void getCount_Ball(int[] userNumbers, List<Ball> systemNumbers, int expect) {
        baseballGame = new BaseballGame(userNumbers, systemNumbers);
        int actual = baseballGame.getCount().getBall();
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBallsAndBallCount() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 3), new Ball(1, 1), new Ball(2, 2)), 3),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 3), new Ball(1, 1), new Ball(2, 7)), 2),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 3), new Ball(1, 4), new Ball(2, 5)), 1),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 4), new Ball(1, 5), new Ball(2, 6)), 0)
                );
    }

    @ParameterizedTest
    @DisplayName("두 야구게임 숫자를 받아, 게임 종료 여부를 반환한다.")
    @MethodSource("provideIsNotOver")
    void isNotOver(int[] userNumbers, List<Ball> systemNumbers, boolean expect) {
        baseballGame = new BaseballGame(userNumbers, systemNumbers);
        boolean actual = baseballGame.isNotOver();
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideIsNotOver() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 1), new Ball(1, 2), new Ball(2, 3)), false),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 2), new Ball(1, 3), new Ball(2, 4)), true),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 3), new Ball(1, 4), new Ball(2, 5)), true),
                Arguments.of(new int[]{1, 2, 3},
                        Arrays.asList(new Ball(0, 4), new Ball(1, 5), new Ball(2, 6)), true)
        );
    }
}