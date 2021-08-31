package model.ball;

import java.util.Objects;

public class BaseballNumber {
    private final int number;

    public BaseballNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(final int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("야구게임을 위한 숫자가 1보다 작거나 9보다 큽니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
