package view;

import model.dto.CountDTO;

public class RoundDisplay {

    private RoundDisplay() {
    }

    public static void alertInput() {
        System.out.print("숫자를 입력하세요 : ");
    }

    public static void showRoundResult(CountDTO count) {
        String result = "";
        if (count.isNothing()) {
            result = "낫씽";
        }
        if (!count.isNothing()) {
            result += concatenateCount(count.getBall(), count.getStrike());
        }
        System.out.println(result);
    }

    private static String concatenateCount(int strike, int ball) {
        String concatenateResult = "";
        if (strike != 0) {
            concatenateResult += strike + "스트라이크";
        }
        if (ball != 0) {
            concatenateResult += ball + "볼";
        }
        return concatenateResult;
    }
}
