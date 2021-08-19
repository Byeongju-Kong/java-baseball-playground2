package model.ball;

import model.BallStatus;

public class Ball {
    private final int position;
    private final BaseballNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new BaseballNumber(number);
    }

    public BallStatus compare(Ball anotherBall) {
        if (isEqualNumberInDifferentPosition(anotherBall.position, anotherBall.number)) {
            return BallStatus.BALL;
        }
        else if(isEqualNumberInSamePosition(anotherBall.position, anotherBall.number)) {
            return BallStatus.STRIKE;
        }
        return BallStatus.NOTHING;
    }

    private boolean isEqualNumberInDifferentPosition(int position, BaseballNumber number) {
        return this.number.equals(number) && this.position != position;
    }

    private boolean isEqualNumberInSamePosition(int position, BaseballNumber number) {
        return this.number.equals(number) && this.position == position;
    }
}
