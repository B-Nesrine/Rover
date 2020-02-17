

public class Plateau {
    private Integer max_X;
    private Integer max_Y;

    public Plateau(Integer max_X, Integer max_Y) {
        this.max_X = max_X;
        this.max_Y = max_Y;
    }

    Boolean isValidMove(Robot robot) {
        if(robot.x>max_X | robot.x<0 | robot.y>max_Y | robot.y<0)
            return false;
        return true;
    }

}
