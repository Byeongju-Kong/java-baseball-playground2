package model;

public class Count {
    private int strike;
    private int ball;

    public Count() {
        strike = 0;
        ball = 0;
    }

    public void countUpStrike() {
        strike++;
    }

    public void countUpBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
