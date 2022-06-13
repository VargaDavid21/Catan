package com.company.Map;

import com.company.Resource.Brick;
import com.company.Resource.Resource;

public class ClayPit extends OperationalTile{
    private static String resource = "Brick";

    public ClayPit() {
        super(resource);
    }

  @Override
    public String toString() {
        return super.toString() + "CP - " + getToken();
    }
}
