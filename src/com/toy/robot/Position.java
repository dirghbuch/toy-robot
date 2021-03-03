package com.toy.robot;

/**
 *  Robot's position in x,y cords, Table size is 5x5 therefore border is 5
 */
public class Position {
    int x;
    int y;
    private static final int BORDER = 5;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (!isValidCoordinate(y)) {
            return;
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (!isValidCoordinate(y)) {
            return;
        }
        this.y = y;
    }

    public static boolean isValidCoordinate(int cord) {
        if (cord > BORDER || cord < 0) {
            return false;
        }
        return true;
    }
}
