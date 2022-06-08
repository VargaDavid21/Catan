package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Wood;

public class Forest extends OperationalTile{
    private Resource resource = new Wood();

    @Override
    public Resource getResource() {
        return resource;
    }


    @Override
    public String toString() {
        return super.toString() + "F - " + getResource();
    }
}
