// You can experiment here, it won’t be checked

import java.util.Arrays;
import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String [] text = sc.nextLine().split("");



    for(int i=0; i<text.length; i++){
      System.out.print(text[i]+text[i]);
    }


  }
}
