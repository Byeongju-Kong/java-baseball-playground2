package model.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    @ParameterizedTest
    @DisplayName("0~32 범위를 벗어난 값으로 Position 객체를 생성하면 예외를 발생시킨다")
    @ValueSource(ints = {-1, 3})
    void create_ExceptionByWrongPositionValue(int wrongPosition) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(wrongPosition))
                .withMessage("위치 값이 잘못 되었습니다.");
    }
}