package model.ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private final List<Ball> numberBalls;

    public Balls(final int[] balls) {
        validateInputBalls(balls);
        numberBalls = parseInputBalls(balls);
    }

    private void validateInputBalls(final int[] inputBalls) {
        int numberOfBalls = 3;
        if (inputBalls.length != numberOfBalls) {
            throw new IllegalArgumentException("숫자의 개수가 잘못되었습니다.");
        }
        if (Arrays.stream(inputBalls).distinct().count() != numberOfBalls) {
            throw new IllegalArgumentException("숫자에 중복이 있습니다.");
        }
    }

    private List<Ball> parseInputBalls(final int[] inputBalls) {
        List<Ball> validatedBalls = new ArrayList<>();
        IntStream.range(0, inputBalls.length)
                .forEach(index -> validatedBalls.add(new Ball(index, inputBalls[index])));
        return validatedBalls;
    }

    public int countSameNumberInSamePosition(final Balls otherBalls) {
        return (int) otherBalls.numberBalls.stream()
                .flatMap(systemBall -> this.numberBalls.stream()
                        .filter(userBall -> userBall.isEqualNumberInSamePosition(systemBall)))
                .count();
    }

    public int countSameNumberInDifferentPosition(final Balls otherBalls) {
        return (int) otherBalls.numberBalls.stream()
                .flatMap(systemBall -> this.numberBalls.stream()
                        .filter(userBall -> userBall.isEqualNumberInDifferentPosition(systemBall)))
                .count();
    }
}
