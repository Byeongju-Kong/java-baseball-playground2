package view;

import model.Count;

public class Display {
    private Display() {
    }

    public static void alertInput() {
        System.out.print("숫자를 입력하세요 : ");
    }

    public static void alertRestartInput() {
        System.out.print("게임을 재시작하려면 1, 종료하려면 2를 누르세요 : ");
    }

    public static void alertOver() {
        System.out.println("게임을 종료합니다.");
    }

    public static void showResult(Count count) {
        System.out.println(count.getStrike() + "Strike " + count.getBall() + "Ball");
    }

    public static void showNothing() {
        System.out.println("Nothing");
    }
}
