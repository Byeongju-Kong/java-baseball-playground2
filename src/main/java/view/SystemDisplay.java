package view;

public class SystemDisplay {
    private SystemDisplay() {
    }

    public static void alertRestartInput() {
        System.out.print("게임을 재시작하려면 1, 종료하려면 2를 누르세요 : ");
    }

    public static void alertOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
    }
}
