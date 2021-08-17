package util;

import java.util.Random;

public class RandomNumber {
    private static final Random RANDOM = new Random();

    private RandomNumber() {
    }

    public static int generateRandomNumber(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("난수의 범위가 잘못되었습니다.");
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }
}
