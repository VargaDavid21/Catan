package com.company.Map;

import com.company.Construction.Construction;

public abstract class Tile {
    private boolean hasThief = false;

    private Construction construction;
    private Construction[][] constructions = null;

    @Override
    public String toString() {
        return "\t   ";
    }
}