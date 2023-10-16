import java.util.*;

public class TicTacToe {

    static String[] board;
    static String userMarker = "X";
    static String computerMarker = "O";

    static void initializeBoard() {
        board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }

    static void printBoard() {
        System.out.println("|---|---|---|");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("|---|---|---|");
        }
    }

    static boolean isBoardFull() {
        for (String cell : board) {
            if (!cell.equals(userMarker) && !cell.equals(computerMarker)) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWin(String player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(player) && board[i + 3].equals(player) && board[i + 6].equals(player)) {
                return true;  // Vertical win
            }
            if (board[i * 3].equals(player) && board[i * 3 + 1].equals(player) && board[i * 3 + 2].equals(player)) {
                return true;  // Horizontal win
            }
        }
        if (board[0].equals(player) && board[4].equals(player) && board[8].equals(player)) {
            return true;  // Diagonal win (top-left to bottom-right)
        }
        if (board[2].equals(player) && board[4].equals(player) && board[6].equals(player)) {
            return true;  // Diagonal win (top-right to bottom-left)
        }
        return false;
    }

    static void playUserMove(Scanner scanner) {
        int userMove = -1;
        while (userMove < 0 || userMove >= 9 || !board[userMove].equals(String.valueOf(userMove + 1))) {
            System.out.print("Enter your move (1-9): ");
            if (scanner.hasNextInt()) {
                userMove = scanner.nextInt() - 1;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                scanner.next();  // Clear invalid input
            }
        }
        board[userMove] = userMarker;
    }

    static void playComputerMove() {
        Random random = new Random();
        int computerMove;
        do {
            computerMove = random.nextInt(9);
        } while (!board[computerMove].equals(String.valueOf(computerMove + 1)));
        board[computerMove] = computerMarker;
        System.out.println("Computer plays at position " + (computerMove + 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();

        while (true) {
            playUserMove(scanner);
            printBoard();
            if (checkWin(userMarker)) {
                System.out.println("Congratulations! You've won!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw! Thanks for playing.");
                break;
            }

            playComputerMove();
            printBoard();
            if (checkWin(computerMarker)) {
                System.out.println("Computer wins! Better luck next time.");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw! Thanks for playing.");
                break;
            }
        }

        scanner.close();
    }
}
