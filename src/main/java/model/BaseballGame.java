package model;

import model.ball.Balls;
import model.dto.CountDTO;

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

    public CountDTO getCount(final int[] inputBalls) {
        Balls userBalls = new Balls(inputBalls);
        int strikeCount = systemBalls.countSameNumberInSamePosition(userBalls);
        int ballCount = systemBalls.countSameNumberInDifferentPosition(userBalls);
        if (strikeCount == 3) {
            notOver = false;
        }
        return new CountDTO(strikeCount, ballCount);
    }
}
