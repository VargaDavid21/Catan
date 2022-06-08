package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Sheep;
import com.company.Resource.Stone;

public class SheepYard extends OperationalTile {
    private static Resource resource = new Sheep();

    public SheepYard() {
        super(resource);
    }

    @Override
    public String toString() {
        return "ShY - " + getResource();
    }
}
