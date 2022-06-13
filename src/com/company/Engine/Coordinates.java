package com.company.Engine;

import com.company.Construction.Construction;

public class Coordinates {
    private final int x; // linie
    private final int y; // coloana

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}