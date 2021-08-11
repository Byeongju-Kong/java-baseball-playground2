package controller;

import model.BaseballGame;
import model.Count;
import view.Display;

import static controller.Input.input;
import static controller.Input.inputRestart;
import static util.RandomNumber.generateThreeRandomBalls;

public class GameController {
    private BaseballGame baseballGame;
    private static final int RESTART_NUMBER = 1;
    private static final int END_NUMBER = 2;
    private int roundNumber = 1;

    private boolean willRestartGame() {
        Display.alertRestartInput();
        int restartNumber = inputRestart();
        if (restartNumber != RESTART_NUMBER && restartNumber != END_NUMBER) {
            throw new IllegalStateException("재시작 혹은 종료를 위한 입력이 잘못 되었습니다");
        }
        return restartNumber == RESTART_NUMBER;
    }

    public void run() {
        boolean restart = true;
        while (restart) {
            play();
            restart = willRestartGame();
        }
        Display.alertOver();
    }

    private void play() {
        Display.alertInput(roundNumber);
        baseballGame = new BaseballGame(input(), generateThreeRandomBalls());
        while (baseballGame.isNotOver()) {
            showRoundResult();
            Display.alertInput(++roundNumber);
            baseballGame.resetUserBalls(input());
        }
        Display.alertSuccess();
    }

    private void showRoundResult() {
        Count count = baseballGame.getCount();
        if (count.isNothing()) {
            Display.showNothing();
        }
        else if(!count.isNothing()) {
            Display.showResult(count);
        }
    }
}
