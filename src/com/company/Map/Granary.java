package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Wheat;

public class Granary extends OperationalTile{
    private Resource resource = new Wheat();

    @Override
    public Resource getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return super.toString() + "G  - " + getResource();
    }
}
