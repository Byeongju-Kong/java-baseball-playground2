package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BallsTest {
    private Balls Balls;

    @Test
    @DisplayName("중복이 있는 숫자를 가진 String[]을 받아 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByOverlap() {
        assertThatThrownBy(() -> new Balls(new String[]{"1", "1", "2"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자에 중복이 있습니다.");
    }

    @Test
    @DisplayName("잘못된 개수의 숫자를 가진 String[]을 받아 객체를 생성하면 예외를 발생시킨다.")
    void create_ExceptionByWrongNumberOfNumbers() {
        assertThatThrownBy(() -> new Balls(new String[]{"1", "2", "3", "4"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 개수가 잘못되었습니다.");
    }
}
