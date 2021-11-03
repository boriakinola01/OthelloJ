import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Board gameBoard = new Board();

        gameBoard.initialiseBoard();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name of Player 1 (Black):");
        String name = input.nextLine();
        Player p1 = new Player(name, 'B');
        name = input.nextLine();
        Player p2 = new Player(name, 'W');

        while(gameBoard.getNumOfTiles() != gameBoard.getSIZE()){
            if(gameBoard.movesAvailable(p1))

        }
        gameBoard.printBoard();
    }
}
