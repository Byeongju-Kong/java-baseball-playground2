package controller;

import view.Display;

import static controller.Input.inputRestart;

public class SystemController {
    private final GameController gameController;
    private static final int RESTART_NUMBER = 1;
    private static final int END_NUMBER = 2;

    public SystemController() {
        gameController = new GameController();
    }

    public void run() {
        boolean restart = true;
        while (restart) {
            gameController.play();
            restart = willRestartGame();
        }
        Display.alertOver();
    }

    private boolean willRestartGame() {
        Display.alertRestartInput();
        int restartNumber = inputRestart();
        if (restartNumber != RESTART_NUMBER && restartNumber != END_NUMBER) {
            throw new IllegalStateException("재시작 혹은 종료를 위한 입력이 잘못 되었습니다");
        }
        return restartNumber == RESTART_NUMBER;
    }
}
