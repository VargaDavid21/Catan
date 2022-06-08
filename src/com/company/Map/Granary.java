package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Wheat;

public class Granary extends OperationalTile{
    private static Resource resource = new Wheat();

    public Granary() {
        super(resource);
    }
    @Override
    public String toString() {
        return "G  - " + getResource();
    }
}
