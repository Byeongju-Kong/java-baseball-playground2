package model;

import java.util.HashSet;
import java.util.Set;

import static util.RandomNumber.generateRandomNumber;

public class RandomNumbers {
    public int[] generateRandomNumbers(final int maxNumber, final int minNumber) {
        Set<Integer> randomThreeBalls = new HashSet<>();
        while (randomThreeBalls.size() < 3) {
            randomThreeBalls.add(generateRandomNumber(maxNumber, minNumber));
        }
        return randomThreeBalls.stream().mapToInt(Integer::intValue).toArray();
    }
}
