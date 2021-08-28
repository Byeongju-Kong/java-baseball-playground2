package model.ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private final List<Ball> numberBalls;
    private static final int NUMBER_OF_BALLS = 3;

    public Balls(int[] balls) {
        validateInputBalls(balls);
        numberBalls = parseInputBalls(balls);
    }

    private void validateInputBalls(int[] inputBalls) {
        if (inputBalls.length != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자의 개수가 잘못되었습니다.");
        }
        if (Arrays.stream(inputBalls).distinct().count() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자에 중복이 있습니다.");
        }
    }

    private List<Ball> parseInputBalls(int[] inputBalls) {
        List<Ball> validatedBalls = new ArrayList<>();
        IntStream.range(0, NUMBER_OF_BALLS)
                .forEach(index -> validatedBalls.add(new Ball(index, inputBalls[index])));
        return validatedBalls;
    }

    public int countSameNumberInSamePosition(Balls otherBalls) {
        return (int) otherBalls.numberBalls.stream()
                .flatMap(systemBall -> this.numberBalls.stream()
                        .filter(userBall -> userBall.isEqualNumberInSamePosition(systemBall)))
                .count();
    }

    public int countSameNumberInDifferentPosition(Balls otherBalls) {
        return (int) otherBalls.numberBalls.stream()
                .flatMap(systemBall -> this.numberBalls.stream()
                        .filter(userBall -> userBall.isEqualNumberInDifferentPosition(systemBall)))
                .count();
    }
}
