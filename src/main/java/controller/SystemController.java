package controller;

import view.Displayable;

public class SystemController {
    private static final int RESTART_NUMBER = 1;
    private static final int END_NUMBER = 2;
    private final BaseBallGameController baseBallGameController;
    private final Displayable display;

    public SystemController(final Displayable display) {
        this.display = display;
        baseBallGameController = new BaseBallGameController(display);
    }

    public void run() {
        boolean restart = true;
        while (restart) {
            baseBallGameController.play();
            restart = willRestartGame();
        }
    }

    private boolean willRestartGame() {
        int restartNumber = display.inputRestart();
        if (restartNumber != RESTART_NUMBER && restartNumber != END_NUMBER) {
            throw new IllegalStateException("재시작 혹은 종료를 위한 입력이 잘못 되었습니다");
        }
        return restartNumber == RESTART_NUMBER;
    }
}