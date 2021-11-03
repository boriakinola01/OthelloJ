import jdk.swing.interop.SwingInterOpUtils;

public class Board {

    private final int SIZE = 8;
    private int numOfTiles;

    public char[][] board = new char[SIZE][SIZE];

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(int x, int y, char c) {
        this.board[x][y] = c;
    }

    public int getSIZE() {
        return SIZE;
    }

    public int getNumOfTiles() {
        return numOfTiles;
    }

    public void setNumOfTiles(int numOfTiles) {
        this.numOfTiles = numOfTiles;
    }




    public void printBoard(Player p1, Player p2){

        System.out.println("Scores: " + p1.getName() + " (Black): " + p1.getScore() + "\t" +
                p2.getName() + " (White): " + p2.getScore());
        System.out.println("     a   b   c   d   e   f   g   h");
        for(int i = 0; i<SIZE;i ++){
            System.out.print("   ");
            for(int j = 0;j<SIZE;j++){
                System.out.print(" ---");
            }
            System.out.println(" ");
            System.out.printf("%d  |", i+1);
            for(int j=0;j<SIZE;j++){
                System.out.printf(" %c", board[i][j]);
                System.out.print(" |");
            }
            System.out.println();
        }
        System.out.print("   ");
        for(int j = 0;j<SIZE;j++){
            System.out.print(" ---");
        }
        System.out.println();
        System.out.print("    ");
        System.out.println(" a   b   c   d   e   f   g   h");
    }

    public boolean isNotEmpty(String input){
        if(board[Character.getNumericValue(input.charAt(1))][input.charAt(0)-'a'] == 'B')
            return true;
        if(board[Character.getNumericValue(input.charAt(1))][input.charAt(0)-'a'] == 'W')
            return true;

        return false;
    }

    public boolean movesAvailable(Player p){

        for(int row = 0; row<SIZE; row++){
            for(int col = 0; col<SIZE; col++){
                if(board[row][col] == ' '){
                    for(int i = -1; i <= 1; i++){
                        for (int j = -1; j <= 1; ++j) {
                            boolean check = validMove(p.getColour(), i, j, row, col);
                            if(check)
                                return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean validMove(char color, int dRow, int dCol, int row, int col){
        char opp = ' ';

        if(color == 'B')
            opp = 'W';
        else if(color == 'W')
            opp = 'B';

        if((row+dRow < 0) || (row+dRow > SIZE-1) || (col+dCol < 0) || (col+dCol > SIZE-1))
            return false;

        if(getBoard()[row+dRow][col+dCol] != opp)
            return false;

        if((row+dRow+dRow < 0) || (row+dRow+dRow > 7) || (col+dCol+dCol < 0) || (col+dCol+dCol > 7))
            return false;


        return lineCheck(color, dRow, dCol, row+dRow+dRow, col+dCol+dCol);

    }

    public boolean lineCheck(char c, int dRow, int dCol, int row, int col){
        if(getBoard()[row][col] == c)
            return true;

        if((row+dRow < 0) || (row+dRow > getSIZE()-1) || (col+dCol < 0) || (col+dCol > getSIZE()-1))
            return false;

        return lineCheck(c, dRow, dCol, row+dRow, col+dCol);
    }

}
