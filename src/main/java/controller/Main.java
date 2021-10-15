package controller;

import view.Displayable;
import view.SystemDisplay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Displayable display = new SystemDisplay(scanner);
        SystemController systemController = new SystemController(display);
        systemController.run();
    }
}