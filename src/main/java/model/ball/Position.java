package model.ball;

import java.util.Objects;

public class Position {
    private static final int MIN_POSITION_VALUE = 0;
    private static final int MAX_POSITION_VALUE = 2;
    private final int value;

    public Position(final int position) {
        validatePosition(position);
        this.value = position;
    }

    private void validatePosition(final int position) {
        if (position < MIN_POSITION_VALUE || position > MAX_POSITION_VALUE) {
            throw new IllegalArgumentException("위치 값이 잘못 되었습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
