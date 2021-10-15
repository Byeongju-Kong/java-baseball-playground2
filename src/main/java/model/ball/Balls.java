package model.ball;

import model.BallStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    private static final int NUMBER_OF_BALLS = 3;
    private final List<Ball> numberBalls;

    public Balls(final int[] ballNumbers) {
        validateInputBalls(ballNumbers);
        numberBalls = parseInputBalls(ballNumbers);
    }

    private void validateInputBalls(final int[] ballNumbers) {
        if (ballNumbers.length != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자의 개수가 잘못되었습니다.");
        }
        if (Arrays.stream(ballNumbers).distinct().count() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자에 중복이 있습니다.");
        }
    }

    private List<Ball> parseInputBalls(final int[] ballNumbers) {
        List<Ball> validatedBalls = new ArrayList<>();
        IntStream.range(0, NUMBER_OF_BALLS)
                .forEach(index -> validatedBalls.add(new Ball(index, ballNumbers[index])));
        return Collections.unmodifiableList(validatedBalls);
    }

    public List<BallStatus> compare(final Balls otherBalls) {
        return numberBalls.stream()
                .map(otherBalls::checkBallStatus)
                .collect(Collectors.toUnmodifiableList());
    }

    private BallStatus checkBallStatus(final Ball otherBall) {
        return numberBalls.stream()
                .map(otherBall::compare)
                .filter(ballStatus -> ballStatus.isBall() || ballStatus.isStrike())
                .findAny()
                .orElse(BallStatus.NOTHING);
    }
}