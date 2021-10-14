package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {
    private BaseballGame baseballGame;

    @ParameterizedTest
    @DisplayName("두 야구게임 숫자를 받아, Count객체를 받아 StrikeCount를 얻는다.")
    @MethodSource("provideBaseballsAndStrikeCount")
    void getCount_Strike(final int[] userNumbers, final int[] systemNumbers, final int expect) {
        baseballGame = new BaseballGame(systemNumbers);
        List<BallStatus> ballStatuses = baseballGame.getCount(userNumbers);
        int actual = (int) ballStatuses.stream()
                .filter(BallStatus::isStrike)
                .count();
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBaseballsAndStrikeCount() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 3),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}, 2),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 1}, 1),
                Arguments.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, 0)
        );
    }

    @ParameterizedTest
    @DisplayName("두 야구게임 숫자를 받아, Count객체를 받아 BallCount를 얻는다.")
    @MethodSource("provideBaseballsAndBallCount")
    void getCount_Ball(final int[] userNumbers, final int[] systemNumbers, final int expect) {
        baseballGame = new BaseballGame(systemNumbers);
        List<BallStatus> ballStatuses = baseballGame.getCount(userNumbers);
        int actual = (int) ballStatuses.stream()
                .filter(BallStatus::isBall)
                .count();
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBaseballsAndBallCount() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 1, 2}, 3),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 1, 4}, 2),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 4, 5}, 1),
                Arguments.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, 0)
        );
    }

    @ParameterizedTest
    @DisplayName("두 야구게임 숫자를 받아, 게임 종료 여부를 반환한다.")
    @MethodSource("provideBaseballsAndIsNotOver")
    void isNotOver(final int[] userNumbers, final int[] systemNumbers, final boolean expect) {
        baseballGame = new BaseballGame(systemNumbers);
        baseballGame.getCount(userNumbers);
        boolean actual = baseballGame.isNotOver();
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBaseballsAndIsNotOver() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, false),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 2}, true),
                Arguments.of(new int[]{1, 2, 3}, new int[]{4, 5, 6}, true)
        );
    }
}