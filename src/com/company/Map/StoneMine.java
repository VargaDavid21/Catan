package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Stone;

public class StoneMine extends OperationalTile  {
    private static Resource resource = new Stone();

    public StoneMine() {
        super(resource);
    }

    @Override
    public String toString() {
        return "StY - " + getResource();
    }
}
