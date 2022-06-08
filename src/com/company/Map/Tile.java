package com.company.Map;

import com.company.Construction.Construction;
import com.company.Resource.Resource;

public abstract class Tile {
    private boolean hasThief = false;

    private Construction[][] constructions = null;

    public Tile()
    @Override
    public String toString() {
        return "\t   ";
    }
}