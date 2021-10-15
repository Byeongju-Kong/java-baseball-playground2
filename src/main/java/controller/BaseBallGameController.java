package controller;

import model.BallStatus;
import model.BaseballGame;
import model.RandomNumbers;
import model.dto.CountDTO;
import model.dto.InputNumberDTO;
import view.Displayable;
import view.rounddisplay.RoundDisplay;

import java.util.List;

import static view.rounddisplay.RoundDisplays.findRoundDisplayStrategy;


public class BaseBallGameController {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final BaseballGame baseballGame;
    private final Displayable display;

    public BaseBallGameController(final Displayable display) {
        this.display = display;
        int[] randomNumbers = new RandomNumbers().generateRandomNumbers(MIN_NUMBER, MAX_NUMBER);
        baseballGame = new BaseballGame(randomNumbers);
    }

    public void play() {
        playWhileNotOver();
        display.alertOver();
    }

    private void playWhileNotOver() {
        do {
            int[] inputNumbers = new InputNumberDTO(display.input()).getValidatedInput();
            List<BallStatus> ballStatuses = baseballGame.getCount(inputNumbers);
            CountDTO countDTO = new CountDTO(ballStatuses);
            RoundDisplay roundDisplay = findRoundDisplayStrategy(countDTO);
            roundDisplay.showRoundResult(countDTO);
        }
        while (baseballGame.isNotOver());
    }
}