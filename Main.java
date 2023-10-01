////////////////
////Opoly
////A board game developed by Benny Mattis to specifications from a course at UMASS Amherst
////////////////
import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Set the board size, then roll the dice and advance your piece across the board by pressing ENTER. Bonus points for landing on spaces number 4, 8, 16, 20 and so on (evenly divisble by 4)...But watch out for a penalty if you land on the second to last space on the board! Win by rolling the right number to land exactly on the board's last space.");
    System.out.println("Enter an int - the size of the board");
    Scanner s = new Scanner(System.in);
    int boardSize = s.nextInt();
    System.out.println("Board Size: " + boardSize);
    Opoly g = new Opoly(boardSize, s);
    g.playGame();
  }
}