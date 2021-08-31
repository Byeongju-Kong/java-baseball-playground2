package model.ball;

public class Ball {
    private final int position;
    private final BaseballNumber number;

    public Ball(final int position, final int number) {
        this.position = position;
        this.number = new BaseballNumber(number);
    }

    public boolean isEqualNumberInDifferentPosition(final Ball otherBall) {
        return otherBall.hasEqualNumber(this.number) && !otherBall.hasSamePosition(this.position);
    }

    public boolean isEqualNumberInSamePosition(final Ball otherBall) {
        return otherBall.hasEqualNumber(this.number) && otherBall.hasSamePosition(this.position);
    }

    private boolean hasEqualNumber(final BaseballNumber number) {
        return this.number.equals(number);
    }

    private boolean hasSamePosition(final int position) {
        return this.position == position;
    }
}
