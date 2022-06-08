package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Sheep;
import com.company.Resource.Stone;

public class SheepYard extends OperationalTile{
    private Resource resource = new Sheep();

    @Override
    public Resource getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return super.toString() + "ShY - " + getResource();
    }
}
