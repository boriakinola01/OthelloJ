public class Player {

    public int score;
    public String name;
    public char colour;

    public Player(String name, char colour) {
        this.name = name;
        this.colour = colour;
    }

    public void move(String input, Board b){

    }


    public boolean checkMove(String input){

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

}
