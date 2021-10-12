package util;

import java.util.Random;

public class RandomNumber {
    private RandomNumber() {
    }

    public static int generateRandomNumber(final int startInclusive, final int endInclusive) {
        Random random = new Random();

        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("난수의 범위가 잘못되었습니다.");
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + random.nextInt(endInclusive - startInclusive + 1);
    }
}
