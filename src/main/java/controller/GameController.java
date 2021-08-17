package controller;

import model.BaseballGame;
import model.ball.Ball;
import model.ball.BaseballNumber;
import model.dto.CountDTO;
import model.dto.InputNumberDTO;
import view.Display;

import java.util.ArrayList;
import java.util.List;

import static controller.Input.input;
import static util.RandomNumber.generateRandomNumber;


public class GameController {
    private BaseballGame baseballGame;

    public void play() {
        Display.alertInput();
        baseballGame = new BaseballGame(new InputNumberDTO(input()).getValidatedInput(), generateThreeRandomBalls(1, 9));
        while (baseballGame.isNotOver()) {
            showRoundResult();
            Display.alertInput();
            baseballGame.resetUserBalls(new InputNumberDTO(input()).getValidatedInput());
        }
    }

    private void showRoundResult() {
        CountDTO count = baseballGame.getCount();
        if (count.isNothing()) {
            Display.showNothing();
        }
        else if(!count.isNothing()) {
            Display.showResult(count);
        }
    }

    private List<Ball> generateThreeRandomBalls(final int minNumber, final int maxNumber) {
        List<Ball> randomThreeBalls = new ArrayList<>();
        int index = 0;
        while(randomThreeBalls.stream().distinct().count() < 3) {
            randomThreeBalls.add(new Ball(index, new BaseballNumber(generateRandomNumber(minNumber, maxNumber))));
            index++;
        }
        return randomThreeBalls;
    }
}
