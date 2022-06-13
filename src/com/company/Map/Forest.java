package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Wood;

public class Forest extends OperationalTile{
    private static String resource = "Wood";

    public Forest() {
        super(resource);
    }
    @Override
    public String toString() {
        return super.toString() + "Fr - " + getToken();
    }
}
