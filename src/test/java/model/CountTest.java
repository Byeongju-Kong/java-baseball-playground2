package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountTest {
    Count count = new Count();

    @Test
    @DisplayName("BallStatus.Strike를 받아 Strike 카운트를 1 증가시킨다.")
    void countUpStrike(){
        count.countUp(BallStatus.STRIKE);
        assertThat(count.getStrike()).isEqualTo(1);
        count.countUp(BallStatus.STRIKE);
        assertThat(count.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("BallStatus.Ball을 받아 Ball 카운트를 1 증가시킨다")
    void countUpBall() {
        count.countUp(BallStatus.BALL);
        assertThat(count.getBall()).isEqualTo(1);
        count.countUp(BallStatus.BALL);
        assertThat(count.getBall()).isEqualTo(2);
    }
}
