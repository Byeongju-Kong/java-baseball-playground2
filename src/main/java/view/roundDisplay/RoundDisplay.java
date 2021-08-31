package view.roundDisplay;

import model.dto.CountDTO;

public interface RoundDisplay {
    void showRoundResult(CountDTO count);
    boolean findRoundDisplayStrategy(CountDTO countDTO);
}
