package model.ball;

public class Ball {
    private final Position position;
    private final BaseballNumber number;

    public Ball(final int position, final int number) {
        this.position = new Position(position);
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

    private boolean hasSamePosition(final Position position) {
        return this.position.equals(position);
    }
}
