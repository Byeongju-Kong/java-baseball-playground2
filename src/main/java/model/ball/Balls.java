package model.ball;

import model.BallStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    private final List<Ball> numberBalls;
    private static final int NUMBER_OF_BALLS = 3;

    public Balls(final int[] balls) {
        validateInputBalls(balls);
        numberBalls = parseInputBalls(balls);
    }

    private void validateInputBalls(final int[] inputBalls) {
        if (inputBalls.length != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자의 개수가 잘못되었습니다.");
        }
        if (Arrays.stream(inputBalls).distinct().count() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자에 중복이 있습니다.");
        }
    }

    private List<Ball> parseInputBalls(final int[] inputBalls) {
        List<Ball> validatedBalls = new ArrayList<>();
        IntStream.range(0, NUMBER_OF_BALLS)
                .forEach(index -> validatedBalls.add(new Ball(index, inputBalls[index])));
        return validatedBalls;
    }

    public List<BallStatus> compare(final Balls otherBalls) {
        return numberBalls.stream()
                .map(otherBalls::checkBallStatus)
                .collect(Collectors.toList());
    }

    private BallStatus checkBallStatus(final Ball otherBall) {
        return numberBalls.stream()
                .map(otherBall::compare)
                .filter(ballStatus -> ballStatus.isBall() || ballStatus.isStrike())
                .findAny()
                .orElse(BallStatus.NOTHING);
    }
}
