package util;

import java.util.Random;

public class RandomNumber {
    private static final Random RANDOM = new Random();

    private RandomNumber() {
    }

    private static int generateRandomNumber(int minNumber, int maxNumber) {
        return minNumber + RANDOM.nextInt(maxNumber - minNumber + 1);
    }
}
