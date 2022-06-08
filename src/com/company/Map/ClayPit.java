package com.company.Map;

import com.company.Resource.Bricks;
import com.company.Resource.Resource;

public class ClayPit extends OperationalTile{
    Resource resource = new Bricks();

    @Override
    public Resource getResource() {
        return resource;
    }

  @Override
    public String toString() {
        return super.toString() + "CP - " + getResource();
    }
}
