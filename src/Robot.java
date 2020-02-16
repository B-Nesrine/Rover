public class Robot {
    Integer x;
    Integer y;
    Character direction;

    public Robot() {
    }

    public Robot(Integer x, Integer y, Character direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    void changePosition() {
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
