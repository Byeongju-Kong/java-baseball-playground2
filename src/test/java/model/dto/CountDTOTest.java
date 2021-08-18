package model.dto;

import model.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountDTOTest {
    CountDTO count = new CountDTO();

    @Test
    @DisplayName("BallStatus.Strike를 받아 Strike 카운트를 1 증가시킨다.")
    void countUpStrike(){
        int expect = count.getStrike() + 1;
        count.countUp(BallStatus.STRIKE);
        int actual = count.getStrike();
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("BallStatus.Ball을 받아 Ball 카운트를 1 증가시킨다")
    void countUpBall() {
        int expect = count.getBall() + 1;
        count.countUp(BallStatus.BALL);
        int actual = count.getBall();
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"STRIKE,false", "NOTHING,true"})
    @DisplayName("낫씽일 경우를 반환한다")
    void isNothing(BallStatus ballStatus, boolean expect) {
        count = new CountDTO();
        count.countUp(ballStatus);
        assertThat(count.isNothing()).isEqualTo(expect);
    }
}
