package com.company.Map;

import com.company.Resource.Resource;

public abstract class OperationalTile extends Tile {
    private Resource resource;
    private int token;

    public OperationalTile(Resource resource) {
        this.resource = resource;
    }

    /*public static OperationalTile createOperationalTileFromStringResource(String resource) {
        if(string not found in resource types din Resource) throw invalid argument..
        switch(...)
    }*/

    public void setToken(int token) {
        this.token = token;
    }

    public int getToken() {
        return token;
    }

    public Resource getResource() {
        return resource;
    }
}
