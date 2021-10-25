public class Board {

    public final int SIZE = 8;

    public char[][] board = new char[SIZE][SIZE];

    public void initialiseBoard(char[][] arr){
        for(int i = 0; i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                // set each 'tile' on the board to empty
                arr[i][j] = ' ';
            }
        }

        arr[3][3] = 'W';
        arr[3][4] = 'B';
        arr[4][3] = 'B';
        arr[4][4] = 'W';
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

    public void updateScore(){

    }

    public static void main(String[] args) {
        Board b = new Board();
        b.initialiseBoard(b.board);
        b.printBoard();
    }

}
