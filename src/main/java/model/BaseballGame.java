package model;

import model.ball.Balls;

import java.util.List;

public class BaseballGame {
    private final Balls systemBalls;
    private List<BallStatus> ballStatuses;

    public BaseballGame(final int[] systemBalls) {
        this.systemBalls = new Balls(systemBalls);
    }

    public boolean isNotOver() {
        return !ballStatuses.stream().allMatch(BallStatus::isStrike);
    }

    public List<BallStatus> getCount(final int[] inputBalls) {
        Balls userBalls = new Balls(inputBalls);
        ballStatuses = systemBalls.compare(userBalls);
        return ballStatuses;
    }
}