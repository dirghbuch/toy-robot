package com.test;

import com.toy.robot.Orientation;
import com.toy.robot.Position;
import com.toy.robot.Robot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    private Robot robot;
    @BeforeEach
    public void setUp() {
        this.robot = new Robot(new Position(1, 1), Orientation.SOUTH);
    }

    @Test
    public void move() {
        this.robot.move();
        assertEquals(this.robot.getPosition().getY(), 0);
    }

    @Test
    public void turnLeft() {
        this.robot.turnLeft();
        assertEquals(this.robot.getOrientation(), Orientation.EAST);
    }

    @Test
    public void turnRight() {
        this.robot.turnRight();
        assertEquals(this.robot.getOrientation(), Orientation.WEST);
    }

    @Test
    public void getPosition() {
        assertEquals(this.robot.getPosition().getX(), 1);
        assertEquals(this.robot.getPosition().getY(), 1);
    }

    @Test
    public void getOrientation() {
        assertEquals(this.robot.getOrientation(), Orientation.SOUTH);
    }


}