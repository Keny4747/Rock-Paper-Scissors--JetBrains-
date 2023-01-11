package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

enum Option {
    ROCK("rock"), PAPER("paper"), SCISSORS("scissors"), GUN("gun"), LIGHTNING("lightning"),
    DEVIL("devil"), DRAGON("dragon"), WATER("water"), AIR("air"), SPONGE("sponge"),
    WOLF("wolf"), TREE("tree"), HUMAN("human"), SNAKE("snake"), FIRE("fire"),
    EXIT("!exit"),
    RATING("!rating");
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
    public static int points = 0;

    public static void main(String[] args) {
        Scanner scanner = scanner();
        String flag = "";
        File file = new File(MyFile.pathFile());
        //Input username:
        String userName = inputUserName(scanner);
        System.out.printf("Hello, %s%n", userName);
        //Input: paper, rock, scissors,!rating, !exit:
        String starGame = inputUser(scanner);
        printStartGame();

        do {
            String userInput = inputUser(scanner);
            //Validate user input:
            if (validateInput(userInput)) {

                switch (userInput) {
                    case "!rating":
                        int rating = MyFile.searchRating(file, userName);
                        MyFile.printRating(rating, points);
                        break;
                    case "":
                    case "rock":
                    case "paper":
                    case "scissors":
                        String computer = randomGenerate();
                        resultGame(userInput, computer);
                        break;
                    default:
                        String[] list = listaUserInput(userInput);
                        String computer2 = randomGenerateList(list);
                        resultGame2(userInput, computer2);
                }

            } else if (userInput.equals(Option.EXIT.value)) {
                break;
            } else {
                System.out.println("Invalid input");
            }

            flag = userInput;

        } while (!flag.equals(Option.EXIT.value));
        System.out.println("Bye!");
    }

    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static String inputUserName(Scanner scanner) {
        System.out.println("Enter your name:");
        return scanner().nextLine();
    }

    public static String inputUser(Scanner scanner) {
        return scanner().nextLine();
    }

    public static String[] listaUserInput(String userInput) {
        return userInput.split(",");
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

    public static String randomGenerateList(String[] list) {
        Random random = new Random();
        int num = random.nextInt(list.length);
        return list[num];
    }

    public static boolean validateInput(String userInput) {

        switch (userInput) {
            case "paper":
            case "rock":
            case "scissors":
            case "!rating":
            case "gun":
            case "lightning":
            case "devil":
            case "dragon":
            case "water":
            case "air":
            case "sponge":
            case "wolf":
            case "tree":
            case "human":
            case "snake":
            case "fire":
                return true;
            default:
                return false;
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

    public static void printStartGame() {
        System.out.println("Okay, let's start");
    }

    public static void resultGame(String user, String computer) {

        if (user.equals(computer)) {
            printResultMessage(Message.DRAW, computer);
            points += 50;
        } else if (user.equals("paper") && computer.equals("rock")) {

            printResultMessage(Message.WIN, computer);
            points += 100;
        } else if (user.equals("rock") && computer.equals("scissors")) {

            printResultMessage(Message.WIN, computer);
            points += 100;
        } else if (user.equals("scissors") && computer.equals("paper")) {

            printResultMessage(Message.WIN, computer);
            points += 100;
        } else {

            printResultMessage(Message.LOSE, computer);
            points += 0;
        }
    }

    public static void resultGame2(String user, String computer) {

        if (user.equals(computer)) {
            printResultMessage(Message.DRAW, computer);
            points += 50;
        } else if (user.equals("paper") && computer.equals("rock")) {

            printResultMessage(Message.WIN, computer);
            points += 100;
        } else if (user.equals("rock") && computer.equals("scissors")) {

            printResultMessage(Message.WIN, computer);
            points += 100;
        } else if (user.equals("scissors") && computer.equals("paper")) {

            printResultMessage(Message.WIN, computer);
            points += 100;
        } else if (user.equals(Option.AIR.value) && computer.equals(Option.PAPER.value)) {
            printResultMessage(Message.WIN, computer);
            points += 100;
        } else {

            printResultMessage(Message.LOSE, computer);
            points += 0;
        }

    }
}

class MyFile {
    public static String pathFile() {
        return "D:\\JetBrains\\rating.txt";
    }

    public static int searchRating(File file, String name) {

        try (Scanner read = new Scanner(file)) {
            while (read.hasNextLine()) {
                if (read.next().contains(name)) {
                    return read.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return 0;
    }

    public static void printRating(int rating, int currentPoint) {
        int total = rating + currentPoint;
        System.out.printf("Your rating: %d%n", total);
    }
}
