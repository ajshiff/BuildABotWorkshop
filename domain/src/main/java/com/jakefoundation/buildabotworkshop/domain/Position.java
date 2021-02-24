package com.jakefoundation.buildabotworkshop.domain;

public class Position {
    private final double x;
    private final double y;

    public Position (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceBetween(Position other) {
        double aSquare = Math.pow(this.x - other.x, 2);
        double bSquare = Math.pow(this.y - other.y, 2);
        double cSquare = aSquare + bSquare;
        return Math.sqrt(cSquare);
    }
}