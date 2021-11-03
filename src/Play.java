import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Board gameBoard = new Board();
        Util util = new Util();


        Scanner input = new Scanner(System.in);

        System.out.println("Enter name of Player 1 (Black):");
        String name = input.nextLine();
        Player p1 = new Player(name, 'B');
        System.out.println("Enter name of Player 2 (White):");
        name = input.nextLine();
        Player p2 = new Player(name, 'W');

        util.initialiseGame(gameBoard, p1, p2);

        gameBoard.printBoard(p1, p2);
        System.out.printf("%s goes first\n", p1.getName());

        while(gameBoard.getNumOfTiles() != gameBoard.getSIZE() * gameBoard.getSIZE()){

            if(gameBoard.movesAvailable(p1)){
                util.play(p1, gameBoard);
                util.updateScore(gameBoard, p1, p2);
                gameBoard.printBoard(p1, p2);
            }

            if(gameBoard.movesAvailable(p2)){

                util.play(p2, gameBoard);
                util.updateScore(gameBoard, p1, p2);
                gameBoard.printBoard(p1, p2);
            }

            if(!gameBoard.movesAvailable(p1) && !gameBoard.movesAvailable(p2))
                break;

        }
        gameBoard.printBoard(p1, p2);
    }


}
