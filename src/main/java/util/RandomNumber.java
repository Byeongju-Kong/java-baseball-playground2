package util;

import java.util.Random;
//TODO : 전략패턴으로 다른 랜덤 값이 필요한 상황에 대비
public class RandomNumber implements util.Random {

    public int generate(int startInclusive, int endInclusive) {
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
