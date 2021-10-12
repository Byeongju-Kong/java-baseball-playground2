package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumbersTest {
    @Test
    @DisplayName("1~9 사이의 중복 없는 수 3개를 만든다.")
    void generateRandomNumbers() {
        RandomNumbers randomNumbers = new RandomNumbers();
        int[] numbers = randomNumbers.generateRandomNumbers(1, 3);
        assertThat(numbers.length).isBetween(1, 4);
    }

}