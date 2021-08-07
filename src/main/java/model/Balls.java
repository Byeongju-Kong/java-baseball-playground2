package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Balls {
    private final Set<Ball> numberBalls;
    private static final int NUMBER_OF_BALLS = 3;

    public Balls(Set<Ball> randomBalls) {
        numberBalls = randomBalls;
    }

    public Balls(String[] inputBalls) {
        numberBalls = validateInputBalls(inputBalls);
    }

    private Set<Ball> validateInputBalls(String[] inputBalls) {
        if (inputBalls.length != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("숫자의 개수가 잘못되었습니다.");
        }
        if (Arrays.stream(inputBalls).distinct().count() > 0){
            throw new IllegalArgumentException("숫자에 중복이 있습니다.");
        }
        Set<Ball> validatedBalls = new HashSet<>();
        IntStream.range(0, NUMBER_OF_BALLS)
                .forEach(index -> validatedBalls.add(new Ball(index, new BaseballNumber(inputBalls[index]))));
        return validatedBalls;
    }
}
