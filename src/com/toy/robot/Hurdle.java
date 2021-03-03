package com.toy.robot;

public class Hurdle {
    Position position;

    public Hurdle(Position position) {
        this.position = position;
    }

    /**
     * Get Position for the Object in X, Y
     *
     * @return Position Position of the Object
     */
    public Position getPosition() {
        return position;
    }
}

