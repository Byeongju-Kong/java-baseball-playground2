package model.ball;

import model.BallStatus;

public class Ball {
    private final Position position;
    private final BaseballNumber number;

    public Ball(final int position, final int number) {
        this.position = new Position(position);
        this.number = new BaseballNumber(number);
    }

    public BallStatus compare(final Ball otherBall) {
        if (isEqualNumberInSamePosition(otherBall)) {
            return BallStatus.STRIKE;
        }
        if (isEqualNumberInDifferentPosition(otherBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isEqualNumberInDifferentPosition(final Ball otherBall) {
        return otherBall.number.equals(this.number) && !otherBall.position.equals(this.position);
    }

    private boolean isEqualNumberInSamePosition(final Ball otherBall) {
        return otherBall.number.equals(this.number) && otherBall.position.equals(this.position);
    }
}
