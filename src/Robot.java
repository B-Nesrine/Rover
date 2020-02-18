
import Exception.BadMoveException;
public class Robot {
    Integer x;
    Integer y;
    Character direction;
	
	@Override
    public String toString() {
        return x + " " + y + "  " + direction;
    }

    public Robot(Integer x, Integer y, Character direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    void changePosition(Plateau plateau) throws BadMoveException {
        switch (this.direction) {
            case 'N':
                this.y++;
                break;
            case 'E':
                this.x++;
                break;
            case 'S':
                this.y--;
                break;
            case 'W':
                this.x--;
                break;
        }
       if(!plateau.isValidMove(this)) throw new BadMoveException("ERROR: The robot is out of the Plateau");
    }


    void goToRight() {
        switch (this.direction) {
            case 'N':
                this.direction = 'E';
                break;
            case 'E':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'N';
                break;
        }
    }

    void goToLeft() {
        switch (this.direction) {
            case 'N':
                this.direction = 'W';
                break;
            case 'E':
                this.direction = 'N';
                break;
            case 'S':
                this.direction = 'E';
                break;
            case 'W':
                this.direction = 'S';
                break;
        }
    }
}
