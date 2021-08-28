package controller;

import model.BaseballGame;
import model.ball.Ball;
import model.dto.CountDTO;
import model.dto.InputNumberDTO;
import view.RoundDisplay;
import view.SystemDisplay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static controller.Input.input;
import static util.RandomNumber.generateRandomNumber;


public class GameController {
    private BaseballGame baseballGame;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public void play() {
        SystemDisplay.alertInput();
        baseballGame = new BaseballGame(new InputNumberDTO(input()).getValidatedInput(), generateThreeRandomBalls());
        playWhileNotOver();
        SystemDisplay.alertOver();
    }

    private void playWhileNotOver() {
        while (baseballGame.isNotOver()) {
            showRoundResult();
            SystemDisplay.alertInput();
            baseballGame.resetUserBalls(new InputNumberDTO(input()).getValidatedInput());
        }
    }

    private void showRoundResult() {
        CountDTO count = baseballGame.getCount();
        RoundDisplay.showRoundResult(count);
    }

    private List<Ball> generateThreeRandomBalls() {
        Set<Ball> randomThreeBalls = new HashSet<>();
        int index = 0;
        while (randomThreeBalls.size() < 3) {
            randomThreeBalls.add(new Ball(index, generateRandomNumber(MIN_NUMBER, MAX_NUMBER)));
            index++;
        }
        return new ArrayList<>(randomThreeBalls);
    }
}
