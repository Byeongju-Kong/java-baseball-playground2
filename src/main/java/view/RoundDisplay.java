package view;

import model.dto.CountDTO;

public class RoundDisplay {
    private static final String EMPTY = "";

    private RoundDisplay() {
    }

    public static void alertInput() {
        System.out.print("숫자를 입력하세요 : ");
    }

    public static void showRoundResult(CountDTO count) {
        String result = EMPTY;
        if (count.isNothing()) {
            result = "낫씽";
        }
        if (!count.isNothing()) {
            result += concatStrikeCount(count.getStrike());
            result += concatBallCount(count.getBall());
        }
        System.out.println(result);
    }

    private static String concatStrikeCount(int strike) {
        if (strike == 0) {
            return EMPTY;
        }
        return strike + "스트라이크";
    }

    private static String concatBallCount(int ball) {
        if (ball == 0) {
            return EMPTY;
        }
        return ball + "볼";
    }
}
