package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

enum Option {
    ROCK("rock"), PAPER("paper"), SCISSORS("scissors");
    String value;

    Option(String value) {
        this.value = value;
    }

}

enum Message {
    DRAW, LOSE, WIN;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String computer = randomGenerate();

        resultGame(userInput, computer);

    }

    public static String randomGenerate() {

        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return Option.ROCK.value;
            case 1:
                return Option.PAPER.value;
            default:
                return Option.SCISSORS.value;
        }
    }

    public static void printResultMessage(Message message, String computer) {
        switch (message) {
            case LOSE:
                System.out.printf("Sorry, but the computer chose %s", computer);
                break;
            case WIN:
                System.out.printf("Well done. The computer chose %s and failed", computer);
                break;
            case DRAW:
                System.out.printf("There is a draw %s", computer);
        }

    }

    public static void resultGame(String user, String computer){
        if (user.equals(computer)) {
            printResultMessage(Message.DRAW, computer);
        } else if (user.equals("paper") && computer.equals("rock")) {
            printResultMessage(Message.WIN, computer);
        } else if (user.equals("rock") && computer.equals("scissors")) {
            printResultMessage(Message.WIN, computer);
        } else if (user.equals("scissors") && computer.equals("paper")) {
            printResultMessage(Message.WIN, computer);
        } else {
            printResultMessage(Message.LOSE, computer);
        }
    }
    public static void loop(){
        
    }
}
