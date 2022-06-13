package com.company.Map;

import com.company.Construction.Construction;

public abstract class Tile {
    private boolean hasThief = false;
    private Construction[][] constructions = new Construction[2][6];

    public void setHasThief(boolean hasThief) {
        this.hasThief = hasThief;
    }

    public Construction[][] getConstructions() {
        return constructions;
    }

    // this is a private method which throws errors for the methods addConstruction() and removeConstruction()
    // in order to not duplicate code, this method was created
    private void validateParams(Construction construction /* nu ar fi logic sa fie HashMap<Player p, Construction c>()???*/ , int x, int y) {
        if (construction == null) {
            throw new IllegalArgumentException ("Construction cannot be null.");
        }
        if (x < 0 || x >= 2) {
            throw new IllegalArgumentException("X cannot be less than 0 or greater than 2. ");
        }
        if (y < 0 || y >= 6) {
            throw new IllegalArgumentException("Y cannot be less than 0 or greater than 6. ");
        }
    }

    public void addConstruction(Construction construction, int x, int y) {
        validateParams(construction, x, y);
        constructions[x][y] = construction;
    }

    public void removeConstruction(Construction construction, int x, int y) {
        validateParams(construction, x, y);
        constructions[x][y] = null;
    }

    @Override
    public String toString() {
        return "\t\t | \t\t" ;
    }
}