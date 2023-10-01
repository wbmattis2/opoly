////////////////
////Opoly
////A board game developed by Benny Mattis to specifications from a course at UMASS Amherst
////////////////
import java.util.*;

public class Opoly{  //This class creates a game in which the goal is to land on spaces evenly divisible by four and avoid the second-to-last space on the board.  Points are calculated with integer multiplication and division according to the rules.
  int boardLen, boardPos=0, rewardTot=10, roundCount;
  boolean gameOver=false;  //returns "true" when game has been finished
  Scanner scan;
  String input;
  
  
  public Opoly(int boardSize, Scanner inputScan){
    boardLen=boardSize+1;  //a zeroth space must be accounted for according to the rules
    this.scan = inputScan;
  }
  
  
  public void playGame(){
    while (!this.gameOver){  //the gameOver variable acts as a switch to continue gameplay
      this.input = this.scan.nextLine();
      this.spinAndMove();
      if (boardPos==boardLen-1){this.gameOver=true;}  //the game is finished if the player lands on the final space
      if (boardPos==boardLen-2){  //if the player lands on the next-to-last-space, they are placed back on space 0 and their score is divided by 4
        boardPos=0;
        rewardTot/=4;
      }
      else{  //the "else" statement is necessary to prevent score multiplication when they land on the next-to-last space
        if (boardPos%4==0){rewardTot*=2;}  //if the number of space a player lands on is evenly divisible by 4, their score is doubled
      }
      this.drawBoard();  //displays state of the board at the end of the round
      roundCount++;  //keeps track of how many rounds have passed so the total can be reported at end of game
    }
    this.displayReport();  //displays the end-of-game status when the while loop has been terminated
    return;
  }
  
  
  public boolean isGameOver(){  //accessor method for the user to determine whether a game object has been played yet
    return gameOver;
  }
  
  public void drawBoard(){  //this displays the "board" and total reward (total score) at the end of a turn
    for (int i=0;i<boardLen;i++){
      if (i==boardPos){System.out.print("O|");}
      else{System.out.print("*|");}
    }
    System.out.println(" "+rewardTot);
  }
  
  
  public int spin(){  //returns an integer between 1 and 5
    return (int)(1+Math.random()*4);
  }
  
  
  public void move(int spinVal){
    if (boardPos+spinVal<boardLen){  //the player must get an exact value to reach the end; if the spinner gives a number greater than the number of spaces in front of you, you don't move.
      boardPos+=spinVal;
    }
  }
  
  
  public void spinAndMove(){  //combines the spin() and move() methods for easier, abstract programming
    int spinVal=spin();
    move(spinVal);
  }
  
  public void displayReport(){  //displays the message at the end of the game, reporting the total number of rounds and the total "reward" at finish.
    System.out.println("game over");
    System.out.println("rounds of play "+roundCount);
    System.out.println("final reward "+rewardTot);
    return;
  }
}