package com.company.Map;

import com.company.Resource.Brick;
import com.company.Resource.Resource;

public class ClayPit extends OperationalTile{
    private static Resource resource = new Brick();

    public ClayPit() {
        super(resource);
    }

  @Override
    public String toString() {
        return "CP - " + getResource();
    }
}
