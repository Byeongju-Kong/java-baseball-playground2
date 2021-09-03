package controller;

import static controller.Input.inputRestart;
import static view.SystemDisplay.alertRestartInput;

public class SystemController {
    private final GameController gameController;
    private static final int RESTART_NUMBER = 1;
    private static final int END_NUMBER = 2;

    public SystemController(final GameController gameController) {
        this.gameController = gameController;
    }

    public void run() {
        boolean restart = true;
        while (restart) {
            gameController.play();
            restart = willRestartGame();
        }
    }

    private boolean willRestartGame() {
        alertRestartInput();
        int restartNumber = inputRestart();
        if (restartNumber != RESTART_NUMBER && restartNumber != END_NUMBER) {
            throw new IllegalStateException("재시작 혹은 종료를 위한 입력이 잘못 되었습니다");
        }
        return restartNumber == RESTART_NUMBER;
    }
}
