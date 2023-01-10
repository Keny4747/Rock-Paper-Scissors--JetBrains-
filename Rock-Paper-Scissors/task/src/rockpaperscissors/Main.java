package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

enum Option {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors"),
    EXIT("!exit");
    String value;

    Option(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

enum Message {
    DRAW, LOSE, WIN;
}

public class Main {
    public static void main(String[] args) {
        String flag ="";
        do {
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            String computer = randomGenerate();

            if(validateInput(userInput)){
                resultGame(userInput,computer);

            }else if(userInput.equals(Option.EXIT.value)){
                break;
            }else{
                System.out.println("Invalid input");
            }

            flag = userInput;

        }while(!flag.equals(Option.EXIT.value));
        System.out.println("Bye!");
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
    public static boolean validateInput(String userInput){

        switch(userInput){
            case "paper":
            case "rock":
            case "scissors":return true;
            default: return false;
        }
    }

    public static void printResultMessage(Message message, String computer) {
        switch (message) {
            case LOSE:
                System.out.printf("Sorry, but the computer chose %s%n", computer);
                break;
            case WIN:
                System.out.printf("Well done. The computer chose %s and failed%n", computer);
                break;
            case DRAW:
                System.out.printf("There is a draw %s%n", computer);
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


}
