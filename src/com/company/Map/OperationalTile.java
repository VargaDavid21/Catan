package com.company.Map;

import com.company.Resource.Bricks;
import com.company.Resource.Resource;

public abstract class OperationalTile extends Tile{
    private Resource resource;
    private int token;

    public OperationalTile(int cordX, int cordY, Resource resource) {
        super(cordX, cordY);
        this.resource = resource;
    }

    public int getToken() {
        int min = 2;
        int max = 12;
        return token = (int)(Math.random()*(max - min + 1) + min);
    }

    public OperationalTile() {
        super();
    }

    public Resource getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return super.toString() + getToken() + " - ";
    }
}
