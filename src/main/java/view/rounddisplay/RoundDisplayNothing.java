package view.rounddisplay;

import model.dto.CountDTO;

public class RoundDisplayNothing implements RoundDisplay {
    public boolean findRoundDisplayStrategy(CountDTO countDTO) {
        return countDTO.isNothing();
    }

    public void showRoundResult(CountDTO countDTO) {
        System.out.println("낫씽");
    }
}
