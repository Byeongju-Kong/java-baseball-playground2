package model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CountDTOTest {
    private CountDTO count;
    @BeforeEach
    void setUp() {
        count = new CountDTO(2, 1);
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
    @CsvSource(value = {"1, 1 ,false", "0, 0,true"})
    @DisplayName("낫씽일 경우를 반환한다")
    void isNothing(int strikeCount, int ballCount, boolean expect) {
        count = new CountDTO(strikeCount, ballCount);
        boolean actual = count.isNothing();
        assertThat(actual).isEqualTo(expect);
    }
}
