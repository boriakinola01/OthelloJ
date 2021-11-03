public class Player {


    private int score;
    private final String name;
    private final char colour;

    public Player(String name, char colour) {
        this.name = name;
        this.colour = colour;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public char getColour() {
        return colour;
    }

    public void movePlayer(String input, Board b){
        char opp = ' ';
        int dRow, dCol, x, y;

        int row = Character.getNumericValue(input.charAt(1)-1);
        int col = input.charAt(0) - 'a';

        b.setBoard(row, col, colour);

        if(getColour() == 'B')
            opp = 'W';
        else if(getColour() == 'W')
            opp = 'B';

        for(dCol = -1; dCol <= 1; dCol++){
            for(dRow = -1; dRow <= 1; dRow++){

                if((row+dRow < 0) || (row+dRow > b.getSIZE()) ||
                        (col+dCol < 0) || (col+dCol > b.getSIZE()) ||
                        (dRow == 0 & dCol == 0))
                    continue;

                if(b.getBoard()[row+dRow][col+dCol] == opp){

                    x = row+dRow;
                    y = col+dCol;

                    while(true){

                        x += dRow;
                        y += dCol;

                        if(x < 0 || x > b.getSIZE()-1 || y <0 || y > b.getSIZE()-1)
                            break;

                        if(b.getBoard()[x][y] == ' ')
                            break;

                        if(b.getBoard()[x][y] == colour){
                            while(b.getBoard()[x-=dRow][y-=dCol] == opp)
                                b.setBoard(x, y, colour);
                            break;
                        }
                    }
                }
            }
        }
    }


}
