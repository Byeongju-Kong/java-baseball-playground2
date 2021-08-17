package util;

import java.util.Random;

public class RandomNumber {
    private static final Random RANDOM = new Random();

    private RandomNumber() {
    }

    public static int generateRandomNumber(int minNumber, int maxNumber) {
        return minNumber + RANDOM.nextInt(maxNumber - minNumber + 1);
    }
}
