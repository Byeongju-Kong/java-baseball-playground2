package controller;

import model.BaseballGame;
import model.dto.InputNumberDTO;

import java.util.HashSet;
import java.util.Set;

import static controller.Input.input;
import static util.RandomNumber.generateRandomNumber;
import static view.RoundDisplay.alertInput;
import static view.RoundDisplay.showRoundResult;
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
            showRoundResult(baseballGame.getCount(new InputNumberDTO(input()).getValidatedInput()));
        }
    }

    private int[] generateThreeRandomBalls() {
        Set<Integer> randomThreeBalls = new HashSet<>();
        while (randomThreeBalls.size() < 3) {
            randomThreeBalls.add(generateRandomNumber(MIN_NUMBER, MAX_NUMBER));
        }
        return randomThreeBalls.stream().mapToInt(Integer::intValue).toArray();
    }
}
