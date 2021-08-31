package view;

import model.dto.CountDTO;

public class RoundDisplaySomething implements RoundDisplay {
    public boolean findRoundDisplayStrategy(CountDTO countDTO){
        return !countDTO.isNothing();
    }

    public void showRoundResult(CountDTO count) {
        String result = concatenateCount(count.getBall(), count.getStrike());
        System.out.println(result);
    }

    private String concatenateCount(int strike, int ball) {
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
