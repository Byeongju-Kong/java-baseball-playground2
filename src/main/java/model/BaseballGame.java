package model;

import java.util.List;

public class BaseballGame {
    private Balls userBalls;
    private final Balls systemBalls;
    private Count count;

    public BaseballGame(String[] userBalls, List<Ball> systemBalls) {
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
        return count.getStrike() != 3;
    }

    public void resetUserBalls(String[] userBalls) {
        this.userBalls = new Balls(userBalls);
    }

    public Count getCount() {
        checkCount();
        return count;
    }
}
