package view;

import java.util.Scanner;

public class SystemDisplay implements Displayable{
    private final Scanner scanner;
    public SystemDisplay(Scanner scanner) {
        this.scanner = scanner;
    }

    public String input() {
        System.out.print("숫자를 입력하세요 : ");
        return scanner.nextLine();
    }

    public int inputRestart() {
        System.out.print("게임을 재시작하려면 1, 종료하려면 2를 누르세요 : ");
        return Integer.parseInt(scanner.nextLine());

    }

    public void alertOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
    }
}