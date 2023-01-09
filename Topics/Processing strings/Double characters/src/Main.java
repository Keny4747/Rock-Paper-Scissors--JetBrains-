import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] text = sc.nextLine().split("");

        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i] + text[i]);
        }
    }
}