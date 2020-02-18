


import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import Exception.*;

public class Rover {


    public static void main(String[] args) {

        try {
            List<String> myInput = Files.lines(Paths.get(args[0]))
                                        .map(s -> s.trim())
                                        .filter(s -> !s.isEmpty())
                                        .collect(Collectors.toList());

            Plateau plateau = getPlateau(myInput.get(0));

            for (int i=1; i<myInput.size();i=i+2) {

                Robot robot = getRobot(myInput.get(i));
                String steps = myInput.get(i+1);

                getFinalPosition(steps, robot, plateau);

            }

        } catch (InvalidInstructionException | BadMoveException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR in the input File");
        }

    }

    private static Plateau getPlateau(String input){
        String inputTab[] = input.split(" ");
        return new  Plateau(Integer.valueOf(inputTab[0]), Integer.valueOf(inputTab[1]));
    }

    private static Robot getRobot(String input) {
        String inputTab[] = input.split(" ");
        return new Robot(Integer.valueOf(inputTab[0]), Integer.valueOf(inputTab[1]), inputTab[2].charAt(0));
    }

    private static void getFinalPosition(String input, Robot robot, Plateau plateau) throws BadMoveException {
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'M':
                    robot.changePosition(plateau);
                    break;
                case 'R':
                    robot.goToRight();
                    break;
                case 'L':
                    robot.goToLeft();
                    break;
                default: throw new InvalidInstructionException("ERROR in instruction sequence of the input.");
            }
        }
        System.out.println(robot);
    }

}
