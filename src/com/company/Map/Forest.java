package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Wood;

public class Forest extends OperationalTile{
    private static Resource resource = new Wood();

    public Forest() {
        super(resource);
    }
    @Override
    public String toString() {
        return "F - " + getResource();
    }
}
