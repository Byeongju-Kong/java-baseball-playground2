package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.RandomNumber.generateRandomNumber;

class RandomNumberTest {
    @Test
    @DisplayName("난수의 범위를 지정하여 범위 내의 난수를 얻는다.")
    void createRandomNumber() {
        int actual = generateRandomNumber(1, 10);
        assertThat(actual).isBetween(1, 10);
    }
}