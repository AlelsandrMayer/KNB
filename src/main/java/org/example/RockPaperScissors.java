package org.example;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {
    private final String[] CHOICES = {"Камень", "Бумага", "Ножницы"};
    private final int[][] RESULT_MATRIX = {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0}
    };

    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private String playerName;
    private Random random;
    private Scanner scanner;

    public RockPaperScissors() {
        gamesPlayed = 0;
        gamesWon = 0;
        gamesLost = 0;
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void playGame() {
        System.out.println("Приветствуем в игре Камень-Ножницы-Бумага!");
        System.out.print("Введите ваше имя: ");
        playerName = scanner.nextLine();

        boolean continuePlaying = true;

        while (continuePlaying) {
            System.out.print("Сколько игр вы хотите сыграть? ");
            int numGames = scanner.nextInt();
            if(numGames == 0){
                break;
            }

            for (int i = 0; i < numGames; i++) {
                int playerChoice = getPlayerChoice();

                if(playerChoice > 2){
                    continuePlaying = false;
                    break;
                }
                int computerChoice = random.nextInt(3);

                System.out.println("Вы выбрали: " + CHOICES[playerChoice]);
                System.out.println("Компьютер выбрал: " + CHOICES[computerChoice]);

                int result = determineWinner(playerChoice, computerChoice);

                if (result == 1) {
                    System.out.println("Вы выиграли!");
                    gamesWon++;
                } else if (result == -1) {
                    System.out.println("Вы проиграли!");
                    gamesLost++;
                } else {
                    System.out.println("Ничья!");
                }

                gamesPlayed++;
            }
            printGameResults();
        }
    }

    private int getPlayerChoice() {
        System.out.println("Сделайте свой выбор, что бы завершить игру введите любое значение больше 2:");
        System.out.println("0 - Камень");
        System.out.println("1 - Бумага");
        System.out.println("2 - Ножницы");
        return scanner.nextInt();
    }

    private int determineWinner(int playerChoice, int computerChoice) {
        return RESULT_MATRIX[playerChoice][computerChoice];
    }

    private void printGameResults() {
        System.out.println("Игра завершена!");
        System.out.println("Сыграно игр: " + gamesPlayed);
        System.out.println("Выиграно: " + gamesWon);
        System.out.println("Проиграно: " + gamesLost);
    }

    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        game.playGame();
    }
}