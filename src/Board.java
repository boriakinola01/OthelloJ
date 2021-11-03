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

    public void initialiseBoard(){
        for(int i = 0; i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                // set each 'tile' on the board to empty
                this.board[i][j] = ' ';
            }
        }

        this.board[3][3] = 'W';
        this.board[3][4] = 'B';
        this.board[4][3] = 'B';
        this.board[4][4] = 'W';
    }


    public void printBoard(){
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
        char opp;

        if(color == 'B')
            opp = 'W';
        else if(color == 'W')
            opp = 'B';


        return false;

    }

    public boolean checkMove(Player p, String input){

        int row = Character.getNumericValue(input.charAt(1));
        int col = input.charAt(0)-'a';

        for(int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; ++j) {
                // check if any of the directions make the move valid
                boolean check = validMove(p.getColour(), i, j, row, col);
                if(check) // if so, return true
                    return true;
            }
        }

        return false;
    }





    public static void main(String[] args) {
        Board b = new Board();
        b.initialiseBoard();
        b.printBoard();
    }

}
