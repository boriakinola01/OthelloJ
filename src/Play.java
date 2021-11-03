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
        name = input.nextLine();
        Player p2 = new Player(name, 'W');

        while(gameBoard.getNumOfTiles() != gameBoard.getSIZE()){

            if(gameBoard.movesAvailable(p1))
                util.play(p1, gameBoard);

            if(gameBoard.movesAvailable(p2))
                util.play(p2, gameBoard);

            if(!gameBoard.movesAvailable(p1) && !gameBoard.movesAvailable(p2))
                break;

        }
        gameBoard.printBoard();
    }
}
