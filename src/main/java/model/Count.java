package model;

public class Count {
    private int strike;
    private int ball;

    public Count() {
        strike = 0;
        ball = 0;
    }

    public void countUp(BallStatus ballStatus) {
        if(ballStatus == BallStatus.STRIKE) {
            strike++;
        }
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
