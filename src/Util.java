import java.util.Scanner;

public class Util {

    public boolean checkInput(String input){

        if(input.charAt(0) < 'a' || input.charAt(0) > 'h')
            return false;

        if(input.charAt(1) < '1' || input.charAt(1) > '8')
            return false;

        return true;
    }

    public boolean checkMove(Player p, Board b, String input){

        int row = Character.getNumericValue(input.charAt(1))-1;
        int col = input.charAt(0)-'a';

        for(int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; ++j) {

                boolean check = b.validMove(p.getColour(), i, j, row, col);
                if(check)
                    return true;
            }
        }

        return false;
    }

    public void play(Player p, Board b){

        System.out.printf("%s\n", p.getName());
        System.out.println("Your move:");

        Scanner input = new Scanner(System.in);
        String slot = input.nextLine();

        if(!slot.equals("p")){
            while(b.isNotEmpty(slot) || !checkMove(p, b, slot) || !checkInput(slot)){
                System.out.println("Invalid move, enter a valid move:");
                slot = input.nextLine();
            }
        }

        // make the player move here
        p.movePlayer(slot, b);

        b.setNumOfTiles(b.getNumOfTiles()+1);
        p.updateScore(b);

    }

    public void initialiseGame(Board b, Player p1, Player p2){
        for(int i = 0; i<b.getSIZE();i++){
            for(int j=0;j<b.getSIZE();j++){
                // set each 'tile' on the board to empty
                b.setBoard(i, j, ' ');
            }
        }

        b.setBoard(3, 3, 'W');
        b.setBoard(4, 4, 'W');
        b.setBoard(3, 4, 'B');
        b.setBoard(4, 4, 'B');

        p1.setScore(2);
        p2.setScore(2);
    }

    public static void main(String[] args) {
        Util util = new Util();

        System.out.println(util.checkInput("d9"));
    }


}
