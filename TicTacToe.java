/*
* This program uses recursion to find all the magic squares of 15 in java.
*
* @author  Cameron Teed
* @version 1.0
* @since   2021-05-13
*/

// Import the Scanner class
import java.util.Scanner;


final class TicTacToe {

  private TicTacToe() {
    // Prevent instantiation
    // Optional: throw an exception e.g. AssertionError
    // if this ever *is* called
    throw new IllegalStateException("Cannot be instantiated");
  }

  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int THREE = 3;
  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int FOUR = 4;
  /**
  * The number to help calculate the perfect sqaure..
  */
  public static final int FIVE = 5;
  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int SIX = 6;
  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int SEVEN = 7;
  /**
  * The number to help calculate the perfect sqaure..
  */
  public static final int EIGHT = 8;
  /**
  * The number to help calculate the perfect sqaure.
  */
  public static final int NINE = 9;
  /**
  * The number the sqaure need to add up too.
  */
  public static final int THIR = 30;
  /**
  * The number the sqaure need to add up too.
  */
  public static final int TWEN = 20;
  /**
   * Finds if the user/computer got three X's/O's in a row, returns true
   * or false.
   *
   * @param board
   * @param takenSpace
   * @return false true
   */
  static boolean winOrLost(final String[] board, final String takenSpace) {
    // returns true or false for whether or not inputted array is a magic square
    return ((board[0] == takenSpace && board[1] == takenSpace && board[2]
            == takenSpace)
         || (board[THREE] == takenSpace && board[FOUR] == takenSpace
             && board[FIVE] == takenSpace)
         || (board[SIX] == takenSpace && board[SEVEN] == takenSpace
             && board[EIGHT] == takenSpace)
         || (board[0] == takenSpace && board[THREE] == takenSpace && board[SIX]
             == takenSpace)
         || (board[1] == takenSpace && board[FOUR] == takenSpace
            && board[SEVEN] == takenSpace)
         || (board[2] == takenSpace && board[FIVE] == takenSpace
             && board[EIGHT] == takenSpace)
         || (board[0] == takenSpace && board[FOUR] == takenSpace
            && board[EIGHT] == takenSpace)
         || (board[2] == takenSpace && board[FOUR] == takenSpace && board[SIX]
            == takenSpace));
  }

  /**
   * Finds the best outcome using the minimax algorithm.
   *
   * @param currentBoard
   * @param countPlace
   * @return currentBoard
   */
  static String[] miniMax(final String[] currentBoard, int countPlace) {
    try {
      // Keep going if counter is less than 9
      if (countPlace < NINE) {

        // find where is numeric on the board
        if (isNumeric(currentBoard[countPlace])) {

          // hold the value of a location in the array
          String valHolder = currentBoard[countPlace];
          // set the value of said location to "O"
          currentBoard[countPlace] = "O";

          //check if victory would be achieved in said scenario
          if (winOrLost(currentBoard, "O")) {
            //set the value that causes victory to "O"
            currentBoard[countPlace] = "O";
            //increase countplace to induce a outofbounds error
            countPlace += THIR;

          // if victory cannot be achieved reset the value of array
          } else {
            // reset the value of a location in the array
            currentBoard[countPlace] = valHolder;
          }

          // set the value of said location to "X"
          currentBoard[countPlace] = "X";

          //check if x victory possible
          if (winOrLost(currentBoard, "X")) {
            //if it is block it
            currentBoard[countPlace] = "O";
            //increase loop variable to prevent further looping
            countPlace += THIR;

          } else {
            // reset the value of a location in the array
            currentBoard[countPlace] = valHolder;
          }
        }
        // Uses recursion to call itself
        miniMax(currentBoard, countPlace + 1);

      // Eliminates all the extreme cases where the user wins
      } else if (countPlace > EIGHT && countPlace < TWEN) {
        extrCase(currentBoard, countPlace);
      }
      return currentBoard;
    /*
     * when an outofbounds error is caught it will only ever be because
     * a win condition was found
     */
    } catch (ArrayIndexOutOfBoundsException exception) {
      return currentBoard;
    }
  }

  /**
   * Finds all the extreme cases where the user wins.
   *
   * @param currentBoard
   * @param countPlace
   * @return currentBoard
   */
  static String[] extrCase(final String[] currentBoard, final int countPlace) {
    int randomNum = (int) (Math.random() * (THREE - 0 + 1) + 0);

        if (isNumeric(currentBoard[FOUR])) {
          currentBoard[FOUR] = "O";

        // eliminating extreme cases where player victory may be possible
        } else if ((currentBoard[FOUR]).equals("O")
                    && (currentBoard[0]).equals("X")
                    && (currentBoard[EIGHT]).equals("X")
                    && isNumeric(currentBoard[1])
                    && isNumeric(currentBoard[THREE])
                    && isNumeric(currentBoard[FIVE])
                    && isNumeric(currentBoard[SEVEN])) {

          if (randomNum == 0 && isNumeric(currentBoard[1])) {
            currentBoard[1] = "O";

          } else if (randomNum == 1 && isNumeric(currentBoard[THREE])) {
            currentBoard[THREE] = "O";

          } else if (randomNum == 2 && isNumeric(currentBoard[FIVE])) {
            currentBoard[FIVE] = "O";

          } else if (randomNum == THREE && isNumeric(currentBoard[SEVEN])) {
            currentBoard[SEVEN] = "O";
          }

        // Eliminating extreme cases where player victory may be possible
        } else if ((currentBoard[FOUR]).equals("O")
                    && (currentBoard[2]).equals("X")
                    && (currentBoard[SIX]).equals("X")
                    && isNumeric(currentBoard[1])
                    && isNumeric(currentBoard[THREE])
                    && isNumeric(currentBoard[FIVE])
                    && isNumeric(currentBoard[SEVEN])) {

          if (randomNum == 0 && isNumeric(currentBoard[1])) {
            currentBoard[1] = "O";

          } else if (randomNum == 1 && isNumeric(currentBoard[THREE])) {
            currentBoard[THREE] = "O";

          } else if (randomNum == 2 && isNumeric(currentBoard[FIVE])) {
            currentBoard[FIVE] = "O";

          } else if (randomNum == THREE && isNumeric(currentBoard[SEVEN])) {
            currentBoard[SEVEN] = "O";
          }

        } else if ((currentBoard[FOUR]).equals("O")
                    && (currentBoard[1]).equals("X")
                    && (currentBoard[THREE]).equals("X")
                    && isNumeric(currentBoard[0])
                    && isNumeric(currentBoard[2])
                    && isNumeric(currentBoard[FIVE])
                    && isNumeric(currentBoard[SIX])
                    && isNumeric(currentBoard[SEVEN])
                    && isNumeric(currentBoard[EIGHT])) {
          currentBoard[0] = "O";

        } else if ((currentBoard[FOUR]).equals("O")
                    && (currentBoard[1]).equals("X")
                    && (currentBoard[FIVE]).equals("X")
                    && isNumeric(currentBoard[0])
                    && isNumeric(currentBoard[2])
                    && isNumeric(currentBoard[THREE])
                    && isNumeric(currentBoard[SIX])
                    && isNumeric(currentBoard[SEVEN])
                    && isNumeric(currentBoard[EIGHT])) {
          currentBoard[2] = "O";

        } else if ((currentBoard[FOUR]).equals("O")
                    && (currentBoard[THREE]).equals("X")
                    && (currentBoard[SEVEN]).equals("X")
                    && isNumeric(currentBoard[0])
                    && isNumeric(currentBoard[1])
                    && isNumeric(currentBoard[2])
                    && isNumeric(currentBoard[FIVE])
                    && isNumeric(currentBoard[SIX])
                    && isNumeric(currentBoard[EIGHT])) {
          currentBoard[SIX] = "O";

        } else if ((currentBoard[FOUR]).equals("O")
                    && (currentBoard[FIVE]).equals("X")
                    && (currentBoard[SEVEN]).equals("X")
                    && isNumeric(currentBoard[0])
                    && isNumeric(currentBoard[1])
                    && isNumeric(currentBoard[2])
                    && isNumeric(currentBoard[THREE])
                    && isNumeric(currentBoard[SIX])
                    && isNumeric(currentBoard[EIGHT])) {
          currentBoard[EIGHT] = "O";

        } else if (randomNum == 1 && isNumeric(currentBoard[2])) {
          currentBoard[2] = "O";

        } else if (randomNum == 2 && isNumeric(currentBoard[SIX])) {
          currentBoard[SIX] = "O";

        } else if (randomNum == THREE && isNumeric(currentBoard[EIGHT])) {
          currentBoard[EIGHT] = "O";

        } else if (randomNum == 0 && isNumeric(currentBoard[1])) {
          currentBoard[1] = "O";

        } else if (randomNum == 1 && isNumeric(currentBoard[THREE])) {
          currentBoard[THREE] = "O";

        } else if (randomNum == 2 && isNumeric(currentBoard[FIVE])) {
          currentBoard[FIVE] = "O";

        } else if (randomNum == THREE && isNumeric(currentBoard[SEVEN])) {
          currentBoard[SEVEN] = "O";
        }
      return currentBoard;
  }

  /**
   * Returns if the board is full or not.
   *
   * @param presentBoard
   * @return full
   */
  static boolean isFull(final String[] presentBoard) {
    boolean full = true;
    for (int counter = 0; counter < presentBoard.length; counter++) {
      if (isNumeric(presentBoard[counter])) {
        full = false;
        break;
      }
    }
    return full;
  }

  /**
   * Pritns out the current board.
   *
   * @param currentBoard
   */
  static void printBoard(final String[] currentBoard) {
    // prints current game state
    System.out.println("----+----+----");
    for (int count = 0; count < NINE; count++) {
      if (count == 2 || count == FIVE || count == EIGHT) {
        System.out.print("| " + currentBoard[count] + " |\n");
        System.out.println("----+----+----");
      } else {
        System.out.print("| " + currentBoard[count] + " ");
      }
    }
  }

  /**
   * Checks if the the square is full or not.
   *
   * @param strNum
   * @return true/false
   */
  static boolean isNumeric(final String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  /**
   * Main function creates the array of numbers for the tic tac toe game and
   * calls the other functions.
   *
   * @param args
   */
  public static void main(final String[] args) {
    // Main stub, get user input here
    boolean boardFull = false;
    boolean checkWinnerX = false;
    boolean checkWinnerO = false;

    // Creates the array of numbers
    Scanner input = new Scanner(System.in);
    String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    System.out.println("Welcome to tic tac toe!\n");

    // Prints the board
    printBoard(board);
    do {
      System.out.println("\nWhich space would you like to put the X? ");
      if (input.hasNextInt()) {
        int space = input.nextInt();

        // Checks if the user is making a valid move
        if (space >= 1 && space <= NINE && isNumeric(board[space - 1])) {
          // Replaces the number in the array with X
          board[space - 1] = "X";

          // place a function call here to get the best move for O
          int countPlace = 0;
          // Finds the best move for O
          miniMax(board, countPlace);

          // Prints the move O made
          printBoard(board);

        // Checks if the spot if taken
        } else if (board[space - 1].equalsIgnoreCase("X")
                   || board[space - 1].equalsIgnoreCase("O")) {
          System.out.println("That spot's taken!");
          printBoard(board);
        } else {
          System.out.println("Error");
          break;
        }
      } else {
        System.out.println("Error");
        break;
      }

      // check to see if anyone wins
      checkWinnerX = winOrLost(board, "X");
      checkWinnerO = winOrLost(board, "O");
      // X has won
      if (checkWinnerX) {
        System.out.println("\nX has won.");
        // O has won
      } else if (checkWinnerO) {
        System.out.println("\nO has won.");
      }

      // Checks if the board is full
      boardFull = isFull(board);
      // Detirmines if the games ends in a draw
      if (boardFull && (!checkWinnerX && !checkWinnerO)) {
      System.out.println("\nDraw.");
      System.out.println("\nGame Over.");
      break;
      // Detirmines if the games ends
      } else if (boardFull || !boardFull && (checkWinnerX  || checkWinnerO)) {
      System.out.println("\nGame Over.");
      break;
      }
    } while (!boardFull);
    System.out.println("\nDone");
  }
}
