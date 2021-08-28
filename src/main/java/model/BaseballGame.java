package model;

import model.ball.Ball;
import model.ball.Balls;
import model.dto.CountDTO;

import java.util.List;

public class BaseballGame {
    private Balls userBalls;
    private final Balls systemBalls;

    public BaseballGame(int[] userBalls, List<Ball> systemBalls) {
        this.userBalls = new Balls(userBalls);
        this.systemBalls = new Balls(systemBalls);
    }

    public boolean isNotOver() {
        return userBalls.countSameNumberInSamePosition(systemBalls) != 3;
    }

    public void resetUserBalls(int[] userBalls) {
        this.userBalls = new Balls(userBalls);
    }

    public CountDTO getCount() {
        int strikeCount = userBalls.countSameNumberInSamePosition(systemBalls);
        int ballCount = userBalls.countSameNumberInDifferentPosition(systemBalls);
        return new CountDTO(strikeCount, ballCount);
    }
}
