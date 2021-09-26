package model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
        assertThatIllegalArgumentException().isThrownBy(() -> new InputNumberDTO("ikl"))
                .withMessage("음수 혹은 특수문자가 입력되었습니다.");
    }
}
