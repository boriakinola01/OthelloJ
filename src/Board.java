public class Board {

    private final int SIZE = 8;

    public char[][] board = new char[SIZE][SIZE];

    public char[][] getBoard() {
        return board;
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



    public static void main(String[] args) {
        Board b = new Board();
        b.initialiseBoard();
        b.printBoard();
    }

}
