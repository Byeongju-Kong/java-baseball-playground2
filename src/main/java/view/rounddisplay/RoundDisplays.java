package view.rounddisplay;

import model.dto.CountDTO;

import java.util.Arrays;
import java.util.List;

public class RoundDisplays {
    private RoundDisplays() {
    }

    private static final List<RoundDisplay> ROUND_DISPLAYS_STRATEGY =
            Arrays.asList(new RoundDisplaySomething(), new RoundDisplayNothing());

    public static RoundDisplay findRoundDisplayStrategy(CountDTO countDTO) {
        return ROUND_DISPLAYS_STRATEGY.stream().
                filter(roundDisplay -> roundDisplay.findRoundDisplayStrategy(countDTO))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("적절한 출력방식이 없습니다."));
    }
}