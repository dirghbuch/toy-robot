package com.toy.commands;

import com.toy.robot.Hurdle;
import com.toy.robot.Orientation;
import com.toy.robot.Position;
import com.toy.robot.Robot;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    Robot robot;
    Set<Hurdle> hurdles;

    // Regex for the place command e.g PLACE 0,0,North
    private static final Pattern PLACE_REGEX = Pattern.compile( "PLACE (\\d+),(\\d+),(\\w+)");
    /**
     * Initialize robot on the table
     *
     * @param command place command from file
     */
    private void initializeRobot(String command) {
        Matcher matcher = PLACE_REGEX.matcher(command);
        if (matcher.matches()) {
            Position position = new Position(Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2)));
            Orientation orientation = Orientation.valueOf(matcher.group(3));
            this.robot = new Robot(position, orientation);
        } else {
            System.err.println("Could not initialize Robot, Place command should be like PLACE 1,1,NORTH");
        }
    }

    /**
     * Initialize robot on the table
     *
     * @param command place command from file
     */
    private void placeHurdle(String command) {
        // get the position of robot
        //increment by one based on orientation
        //place the hurdle
        Hurdle hurdle = new Hurdle();

    }

    /**
     * Parse the command from file to move Robot around on the table
     *
     * @param command Command from file
     */
    public void parse(String command) {
        if(command.startsWith("PLACE")) {
          initializeRobot(command);
        } else {
            if(this.robot == null) {
                System.err.println("Robot Not placed on the Table");
                return;
            }
            switch (command) {
                case "PLACE_OBJECT":

                case "MOVE":
                    this.robot.move();
                    break;
                case "LEFT":
                    this.robot.turnLeft();
                    break;
                case "RIGHT":
                    this.robot.turnRight();
                    break;
                case "REPORT":
                    System.out.println(this.robot.getPosition().getX() + ", " + this.robot.getPosition().getY() + ", " + this.robot.getOrientation().toString());
            }
        }
    }
}
