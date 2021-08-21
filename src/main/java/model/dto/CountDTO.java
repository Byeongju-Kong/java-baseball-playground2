package model.dto;

public class CountDTO {
    private final int strike;
    private final int ball;

    public CountDTO(int strikeCount, int ballCount) {
        strike = strikeCount;
        ball = ballCount;
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
