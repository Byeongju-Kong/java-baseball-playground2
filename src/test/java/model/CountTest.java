package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountTest {
    Count count = new Count();

    @Test
    @DisplayName("countUpStrike을 호출하면 Strike 카운트가 1 증가한다.")
    void countUpStrike(){
        count.countUpStrike();
        assertThat(count.getStrike()).isEqualTo(1);
        count.countUpStrike();
        assertThat(count.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("countUpBall을 호출하면 Ball 카운트가 1 증가한다.")
    void countUpBall() {
        count.countUpBall();
        assertThat(count.getBall()).isEqualTo(1);
        count.countUpBall();
        assertThat(count.getBall()).isEqualTo(2);
    }
}
