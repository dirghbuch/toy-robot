package com.toy.robot;

public class Robot {
    Position position;
    Orientation orientation;
    int STEP = 1;

    public Robot(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    /**
     * Move robot on the table by one unit
     */
    public void move() {
        switch (this.orientation) {
            case NORTH:
                this.position.setY(this.position.getY() + STEP);
                break;
            case EAST:
                this.position.setX(this.position.getX() + STEP);
                break;
            case SOUTH:
                this.position.setY(this.position.getY() - STEP);
                break;
            case WEST:
                this.position.setX(this.position.getX() - STEP);
                break;
            default:
                System.err.println("Unknown Orientation: " + this.orientation.toString());
        }
    }

    public Position getNextMove() {
        switch (this.orientation) {
            case NORTH:
                return new Position(this.position.getX(),this.position.getY() + STEP);
            case EAST:
                return new Position(this.position.getX() + STEP, this.position.getY());
            case SOUTH:
                return new Position(this.position.getX(), this.position.getY() - STEP);
            case WEST:
                return new Position(this.position.getX() - STEP, this.position.getY());
        }
    }

    /**
     * Turn robot to the left
     */
    public void turnLeft() {
        this.orientation = this.orientation.left();
    }

    /**
     * Turn robot to right
     */
    public void turnRight() {
        this.orientation = this.orientation.right();
    }

    /**
     * Get Position for the robot in X, Y
     * @return Position Position of the Robot
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Get Orientation of the robot like North, South
     * @return Orientation Orientation of the Robot
     */
    public Orientation getOrientation() {
        return orientation;
    }
}
