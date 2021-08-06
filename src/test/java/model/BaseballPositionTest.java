package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BaseballPositionTest {
    private BaseballPosition baseballPosition;

    @Test
    @DisplayName("3보다 큰 값으로 위치 값을 생성하면 예외를 발생시킨다.")
    void create_ExceptionByGreaterValue() {
        assertThatThrownBy(()-> new BaseballPosition(4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치 값이 잘못 되었습니다");
    }

    @Test
    @DisplayName("3보다 큰 값으로 위치 값을 생성하면 예외를 발생시킨다.")
    void create_ExceptionByLessValue() {
        assertThatThrownBy(()-> new BaseballPosition(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 위치 값이 잘못 되었습니다");
    }
}
