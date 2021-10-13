package model.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseballNumberTest {
    @ParameterizedTest
    @DisplayName("9보다 큰 숫자로 BaseballNumber 객체를 생성하면 예외를 발생시킨다")
    @ValueSource(ints = {0, 10})
    void create_ExceptionByGreaterArgument(final int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new BaseballNumber(number))
                .withMessage("야구게임을 위한 숫자가 1보다 작거나 9보다 큽니다");
    }
}
