package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Stone;

public class StoneYard extends OperationalTile{
    private Resource resource = new Stone();

    @Override
    public Resource getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return super.toString() + "StY - " + getResource();
    }
}
