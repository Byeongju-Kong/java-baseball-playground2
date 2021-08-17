package model.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @Test
    @DisplayName("9보다 큰 숫자로 BaseballNumber 객체를 생성하면 예외를 발생시킨다")
    void create_ExceptionByGreaterArgument() {
        assertThatThrownBy(() -> new BaseballNumber(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구게임을 위한 숫자가 1보다 작거나 9보다 큽니다");
    }

    @Test
    @DisplayName("1보다 작은 숫자로 BaseballNumber 객체를 생성하면 예외를 발생시킨다")
    void create_ExceptionByLessArgument() {
        assertThatThrownBy(() -> new BaseballNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구게임을 위한 숫자가 1보다 작거나 9보다 큽니다");
    }
}
