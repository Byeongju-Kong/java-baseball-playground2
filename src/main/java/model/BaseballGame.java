package model;

import model.ball.Balls;

import java.util.List;

public class BaseballGame {
    private final Balls systemBalls;
    private boolean notOver;

    public BaseballGame(final int[] systemBalls) {
        this.systemBalls = new Balls(systemBalls);
        notOver = true;
    }

    public boolean isNotOver() {
        return notOver;
    }

    public List<BallStatus> getCount(final int[] inputBalls) {
        Balls userBalls = new Balls(inputBalls);
        List<BallStatus> ballStatuses = systemBalls.compare(userBalls);
        checkGameIsOver(ballStatuses);
        return ballStatuses;
    }

    private void checkGameIsOver(final List<BallStatus> ballStatuses) {
        if (ballStatuses.stream().allMatch(BallStatus::isStrike)){
            notOver = false;
        }
    }
}
