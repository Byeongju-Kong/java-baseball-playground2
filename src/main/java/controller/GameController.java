package controller;

import model.BaseballGame;
import model.ball.Ball;
import model.ball.BaseballNumber;
import model.dto.CountDTO;
import model.dto.InputNumberDTO;
import view.SystemDisplay;

import java.util.ArrayList;
import java.util.List;

import static controller.Input.input;
import static util.RandomNumber.generateRandomNumber;


public class GameController {
    private BaseballGame baseballGame;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public void play() {
        SystemDisplay.alertInput();
        baseballGame = new BaseballGame(new InputNumberDTO(input()).getValidatedInput(), generateThreeRandomBalls());
        while (baseballGame.isNotOver()) {
            showRoundResult();
            SystemDisplay.alertInput();
            baseballGame.resetUserBalls(new InputNumberDTO(input()).getValidatedInput());
        }
    }

    private void showRoundResult() {
        CountDTO count = baseballGame.getCount();
        if (count.isNothing()) {
            SystemDisplay.showNothing();
        }
        else if(!count.isNothing()) {
            SystemDisplay.showResult(count);
        }
    }

    private List<Ball> generateThreeRandomBalls() {
        List<Ball> randomThreeBalls = new ArrayList<>();
        int index = 0;
        while(randomThreeBalls.stream().distinct().count() < 3) {
            randomThreeBalls.add(new Ball(index, new BaseballNumber(generateRandomNumber(MIN_NUMBER, MAX_NUMBER))));
            index++;
        }
        return randomThreeBalls;
    }
}
