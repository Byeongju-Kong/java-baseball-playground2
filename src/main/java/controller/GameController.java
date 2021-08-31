package controller;

import model.BaseballGame;
import model.dto.CountDTO;
import model.dto.InputNumberDTO;
import util.Random;
import util.RandomNumber;
import view.RoundDisplay;
import view.RoundDisplayNothing;
import view.RoundDisplaySomething;

import java.util.HashSet;
import java.util.Set;

import static controller.Input.input;
import static view.RoundDisplays.findRoundDisplayStrategy;
import static view.SystemDisplay.alertInput;
import static view.SystemDisplay.alertOver;


public class GameController {
    private BaseballGame baseballGame;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public void play() {
        baseballGame = new BaseballGame(generateThreeRandomBalls());
        playWhileNotOver();
        alertOver();
    }

    private void playWhileNotOver() {
        while (baseballGame.isNotOver()) {
            alertInput();
            CountDTO countDTO = baseballGame.getCount(new InputNumberDTO(input()).getValidatedInput());
            RoundDisplay roundDisplay = findRoundDisplayStrategy(countDTO);
            roundDisplay.showRoundResult(countDTO);
        }
    }

    private int[] generateThreeRandomBalls() {
        Set<Integer> randomThreeBalls = new HashSet<>();
        Random randomNumber = new RandomNumber();
        while (randomThreeBalls.size() < 3) {
            randomThreeBalls.add(randomNumber.generate(MIN_NUMBER, MAX_NUMBER));
        }
        return randomThreeBalls.stream().mapToInt(Integer::intValue).toArray();
    }
}
