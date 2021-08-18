package model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputDTOTest {
    @Test
    @DisplayName("숫자만을 요소로 가지는 문자열을 받아 유효검사를 하고 int[]로 반환한다. ")
    void getValidatedToken() {
        InputNumberDTO inputDTO = new InputNumberDTO("123");
        int[] actual = inputDTO.getValidatedInput();
        int[] expect = new int[]{1, 2, 3};
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("문자 요소가 포함된 문자열을 받으면 예외를 발생시킨다.")
    void getValidatedToken_ExceptionByNonNumber() {
        assertThatThrownBy(() -> new InputNumberDTO("ikl"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 입력이 있습니다.");
    }
}
