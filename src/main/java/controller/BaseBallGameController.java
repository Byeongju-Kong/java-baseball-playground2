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


public class BaseBallGameController{
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private BaseballGame baseballGame;
    private final Displayable display;

    public BaseBallGameController(final Displayable display) {
        this.display = display;
    }

    public void play() {
        int[] randomNumbers = new RandomNumbers().generateRandomNumbers(MIN_NUMBER, MAX_NUMBER);
        baseballGame = new BaseballGame(randomNumbers);
        playWhileNotOver();
        display.alertOver();
    }

    private void playWhileNotOver() {
        while (baseballGame.isNotOver()) {
            List<BallStatus> ballStatuses = baseballGame.getCount(new InputNumberDTO(display.input()).getValidatedInput());
            CountDTO countDTO = new CountDTO(ballStatuses);
            RoundDisplay roundDisplay = findRoundDisplayStrategy(countDTO);
            roundDisplay.showRoundResult(countDTO);
        }
    }
}
