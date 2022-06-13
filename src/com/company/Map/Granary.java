package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Wheat;

public class Granary extends OperationalTile{
    private static String resource = "Wheat";

    public Granary() {
        super(resource);
    }
    @Override
    public String toString() {
        return  super.toString() + "Gr  - " + getToken();
    }
}
