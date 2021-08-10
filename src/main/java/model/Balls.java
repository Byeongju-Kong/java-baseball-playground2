package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private final List<Ball> numberBalls;
    private static final int NUMBER_OF_BALLS = 3;

    public Balls(List<Ball> randomBalls) {
        numberBalls = randomBalls;
    }

    public Balls(String[] inputBalls) {
        numberBalls = validateInputBalls(inputBalls);
    }

    private List<Ball> validateInputBalls(String[] inputBalls) {
        if (inputBalls.length != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자의 개수가 잘못되었습니다.");
        }
        if (Arrays.stream(inputBalls).distinct().count() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자에 중복이 있습니다.");
        }
        List<Ball> validatedBalls = new ArrayList<>();
        IntStream.range(0, NUMBER_OF_BALLS)
                .forEach(index -> validatedBalls.add(new Ball(index, new BaseballNumber(inputBalls[index]))));
        return validatedBalls;
    }

    public BallStatus compare(Ball ball) {
        return numberBalls.stream()
                .map(target -> target.compare(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
