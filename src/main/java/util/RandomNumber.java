package util;

import model.Ball;
import model.BaseballNumber;

import java.util.*;
import java.util.stream.IntStream;

public class RandomNumber {
    private static final int NUMBER_OF_NUMBERS = 3;
    private static final int BASEBALL_NUMBER_BOUNDARY = 9;
    private static Random random = new Random();

    private RandomNumber() {
    }

    private static BaseballNumber generateRandomBaseballNumber() {
        return new BaseballNumber(random.nextInt(BASEBALL_NUMBER_BOUNDARY) + 1);
    }

    private static Set<BaseballNumber> generateNonOverlappedRandomBaseballNumbers() {
        Set<BaseballNumber> randomBaseballNumbers = new HashSet<>();
        while (randomBaseballNumbers.size() < NUMBER_OF_NUMBERS) {
            randomBaseballNumbers.add(generateRandomBaseballNumber());
        }
        return randomBaseballNumbers;
    }

    public static List<Ball> generateThreeRandomBalls() {
        Set<BaseballNumber> randomBaseballNumbers = generateNonOverlappedRandomBaseballNumbers();
        List<Ball> randomBalls = new ArrayList<>();
        Iterator<BaseballNumber> baseballNumberIterator = randomBaseballNumbers.iterator();
        IntStream.range(0, NUMBER_OF_NUMBERS)
                .forEach(index -> randomBalls.add(new Ball(index, baseballNumberIterator.next())));
        return randomBalls;
    }
}
