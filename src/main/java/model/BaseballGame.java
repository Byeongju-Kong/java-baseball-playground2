package model;

import model.ball.Ball;
import model.ball.Balls;

import java.util.List;

public class BaseballGame {
    private Balls userBalls;
    private final Balls systemBalls;
    private Count count;

    public BaseballGame(int[] userBalls, List<Ball> systemBalls) {
        this.userBalls = new Balls(userBalls);
        this.systemBalls = new Balls(systemBalls);
        checkCount();
    }

    private void checkCount() {
        count = new Count();
        userBalls.getNumberBalls()
                .forEach(ball -> count.countUp(systemBalls.compare(ball)));
    }

    public boolean isNotOver() {
        checkCount();
        return count.getStrike() != 3;
    }

    public void resetUserBalls(int[] userBalls) {
        this.userBalls = new Balls(userBalls);
    }

    public Count getCount() {
        checkCount();
        return count;
    }
}
