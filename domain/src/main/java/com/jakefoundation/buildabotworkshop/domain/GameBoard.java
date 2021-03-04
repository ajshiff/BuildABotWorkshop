package com.jakefoundation.buildabotworkshop.domain;

public class GameBoard {
    private final int x;
    private final int y;

    public GameBoard(int x, int y){

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
