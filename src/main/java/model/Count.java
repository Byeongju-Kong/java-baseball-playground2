package model;

public class Count {
    private int strike;
    private int ball;

    public Count() {
        strike = 0;
        ball = 0;
    }

    public void countUp(BallStatus ballStatus) {
        if (ballStatus == BallStatus.STRIKE) {
            strike++;
        }
        if (ballStatus == BallStatus.BALL) {
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
