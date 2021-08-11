package model.ball;

import model.BallStatus;

public class Ball {
    private final int position;
    private final BaseballNumber number;

    public Ball(int position, BaseballNumber number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus compare(Ball anotherBall) {
        if (anotherBall.isEqualNumberInDifferentPosition(position, number)) {
            return BallStatus.BALL;
        }
        else if(anotherBall.isEqualNumberInSamePosition(position, number)) {
            return BallStatus.STRIKE;
        }
        return BallStatus.NOTHING;
    }

    private boolean isEqualNumberInDifferentPosition(int position, BaseballNumber number) {
        return this.position != position && this.number.equals(number);
    }

    private boolean isEqualNumberInSamePosition(int position, BaseballNumber number) {
        return this.position == position && this.number.equals(number);
    }
}
