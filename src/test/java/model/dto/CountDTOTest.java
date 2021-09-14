package model.dto;

import model.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountDTOTest {
    private CountDTO count;
    @BeforeEach
    void setUp() {
        count = new CountDTO(Arrays.asList(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.BALL));
    }

    @Test
    @DisplayName("Ball 카운트를 반환한다.")
    void getBall() {
        assertThat(count.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("Strike 카운트를 반환한다.")
    void getStrike() {
        assertThat(count.getStrike()).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("provideBallStatusAndNothingCheck")
    @DisplayName("낫씽일 경우를 반환한다")
    void isNothing(List<BallStatus> ballStatuses, boolean expect) {
        count = new CountDTO(ballStatuses);
        boolean actual = count.isNothing();
        assertThat(actual).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBallStatusAndNothingCheck() {
        return Stream.of(
                Arguments.of(Arrays.asList(BallStatus.NOTHING, BallStatus.NOTHING, BallStatus.NOTHING), true),
                Arguments.of(Arrays.asList(BallStatus.STRIKE, BallStatus.NOTHING, BallStatus.NOTHING), false)
        );
    }
}
