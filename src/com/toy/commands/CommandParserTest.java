package com.toy.commands;

import com.toy.robot.Orientation;
import com.toy.robot.Position;
import com.toy.robot.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    CommandParser commandParser;

    @BeforeEach
    void setUp() {
        this.commandParser = new CommandParser();
        String command = "PLACE 1,2,WEST";
        this.commandParser.parse(command);
    }

    @Test
    void parsePlace() {
        String command = "PLACE 1,2,EAST";
        this.commandParser.parse(command);
        assertEquals(this.commandParser.robot.getOrientation(), Orientation.EAST);
        assertEquals(this.commandParser.robot.getPosition().getX(), 1);
        assertEquals(this.commandParser.robot.getPosition().getY(), 2);
    }

    @Test
    void parseMove() {
        String command = "MOVE";
        this.commandParser.parse(command);
        assertEquals(this.commandParser.robot.getOrientation(), Orientation.WEST);
        assertEquals(this.commandParser.robot.getPosition().getX(), 0);
    }

    @Test
    void parseLeft() {
        String command = "LEFT";
        this.commandParser.parse(command);
        assertEquals(this.commandParser.robot.getOrientation(), Orientation.SOUTH);
        assertEquals(this.commandParser.robot.getPosition().getX(), 1);
    }

    @Test
    void parseRight() {
        String command = "RIGHT";
        this.commandParser.parse(command);
        assertEquals(this.commandParser.robot.getOrientation(), Orientation.NORTH);
        assertEquals(this.commandParser.robot.getPosition().getX(), 1);
    }

    @Test
    void ignoreFallingOfRobot() {
        String command = "PLACE 0,0,SOUTH";
        this.commandParser.parse(command);
        assertEquals(this.commandParser.robot.getOrientation(), Orientation.SOUTH);
        assertEquals(this.commandParser.robot.getPosition().getX(), 0);
        assertEquals(this.commandParser.robot.getPosition().getY(), 0);
        command = "MOVE";
        this.commandParser.parse(command);
        assertNotEquals(this.commandParser.robot.getPosition().getY(), -1);
        assertEquals(this.commandParser.robot.getOrientation(), Orientation.SOUTH);
        assertEquals(this.commandParser.robot.getPosition().getX(), 0);
        assertEquals(this.commandParser.robot.getPosition().getY(), 0);

    }
}