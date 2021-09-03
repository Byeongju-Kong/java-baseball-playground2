package model.dto;

import model.BallStatus;

import java.util.List;

public class CountDTO {
    private final int strike;
    private final int ball;

    public CountDTO(final List<BallStatus> balStatuses) {
        strike = (int) balStatuses.stream()
                .filter(BallStatus::isStrike)
                .count();
        ball = (int) balStatuses.stream()
                .filter(BallStatus::isBall)
                .count();
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
