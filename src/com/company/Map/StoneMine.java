package com.company.Map;

import com.company.Resource.Resource;
import com.company.Resource.Stone;

public class StoneMine extends OperationalTile  {
    private static String resource = "Stone";

    public StoneMine() {
        super(resource);
    }

    @Override
    public String toString() {
        return super.toString() + "StY - " + getToken();
    }
}
