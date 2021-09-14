package controller;

import model.BaseballGame;
import model.dto.CountDTO;
import model.dto.InputNumberDTO;
import model.RandomNumber;
import view.Displayable;
import view.rounddisplay.RoundDisplay;

import java.util.HashSet;
import java.util.Set;

import static view.rounddisplay.RoundDisplays.findRoundDisplayStrategy;


public class BaseBallGameController{
    private BaseballGame baseballGame;
    private final Displayable display;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public BaseBallGameController(Displayable display) {
        this.display = display;
    }

    public void play() {
        baseballGame = new BaseballGame(generateThreeRandomBalls());
        playWhileNotOver();
        display.alertOver();
    }

    private void playWhileNotOver() {
        while (baseballGame.isNotOver()) {
            CountDTO countDTO = baseballGame.getCount(new InputNumberDTO(display.input()).getValidatedInput());
            RoundDisplay roundDisplay = findRoundDisplayStrategy(countDTO);
            roundDisplay.showRoundResult(countDTO);
        }
    }

    private int[] generateThreeRandomBalls() {
        Set<Integer> randomThreeBalls = new HashSet<>();
        RandomNumber randomNumber = new RandomNumber();
        while (randomThreeBalls.size() < 3) {
            randomThreeBalls.add(randomNumber.generate(MIN_NUMBER, MAX_NUMBER));
        }
        return randomThreeBalls.stream().mapToInt(Integer::intValue).toArray();
    }
}
