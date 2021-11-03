import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Board gameBoard = new Board();
        Util util = new Util();

        gameBoard.initialiseBoard();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name of Player 1 (Black):");
        String name = input.nextLine();
        Player p1 = new Player(name, 'B');
        System.out.println("Enter name of Player 2 (White):");
        name = input.nextLine();
        Player p2 = new Player(name, 'W');

        while(gameBoard.getNumOfTiles() != gameBoard.getSIZE()){

            if(gameBoard.movesAvailable(p1)){
                gameBoard.printBoard();
                util.play(p1, gameBoard);
                gameBoard.printBoard();
                printScoreboard(p1, p2);
            }

            if(gameBoard.movesAvailable(p2)){
                gameBoard.printBoard();
                util.play(p2, gameBoard);
                gameBoard.printBoard();
                printScoreboard(p1, p2);
            }

            if(!gameBoard.movesAvailable(p1) && !gameBoard.movesAvailable(p2))
                break;

        }
        gameBoard.printBoard();
    }

    public static void printScoreboard(Player p1, Player p2){
        System.out.printf("Scores: %s (Black):%d \t %s (White):%d", p1.getName(), p1.getScore(), p2.getName(), p2.getScore());
    }
}
