package model;

import java.util.Objects;

public class BaseballPosition {
    private final int position;

    public BaseballPosition(int position) {
        if (isInvalidPosition(position)) {
            throw new IllegalArgumentException("숫자의 위치 값이 잘못 되었습니다");
        }
        this.position = position;
    }

    private boolean isInvalidPosition(int position) {
        return position < 1 || position > 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballPosition that = (BaseballPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
