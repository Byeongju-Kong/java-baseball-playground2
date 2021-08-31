package model.ball;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int position) {
        validatePosition(position);
        this.value = position;
    }

    private void validatePosition(int position) {
        if (position < 0 || position > 2) {
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
