import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Rover {

    public static void main(String[] args) {

        List<String> myInput;

        try {
            myInput = Files.lines(Paths.get(args[0]))
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            for (int i=1; i<myInput.size();i=i+2) {
                Robot robot = new Robot();
                String steps;

                getFirstPosition(myInput.get(i), robot);
                steps = myInput.get(i+1);

                getFinalPosition(steps, robot);
                System.out.println(robot.x + " " + robot.y + "  " + robot.direction);
            }



        } catch (Exception e) {
            System.out.println("ERROR in the input File");
        }

    }

    private static void getFirstPosition(String input, Robot robot) {
        String inputTab[] = input.split(" ");
        robot.x = Integer.valueOf(inputTab[0]);
        robot.y = Integer.valueOf(inputTab[1]);
        robot.direction = inputTab[2].charAt(0);
    }

    private static void getFinalPosition(String input, Robot robot) {

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'M':
                    robot.changePosition();
                    break;
                case 'R':
                    robot.goToRight();
                    break;
                case 'L':
                    robot.goToLeft();
                    break;
            }
        }
    }

}
