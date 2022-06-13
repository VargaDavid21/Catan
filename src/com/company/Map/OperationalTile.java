package com.company.Map;

import com.company.Construction.Construction;
import com.company.Resource.Resource;

public abstract class OperationalTile extends Tile {
    public static final String[] OPERATIONAL_TILE_TYPES = {"ClayPit", "Forest", "Granary", "SheepYard", "StoneMine"};
    private static final String pack = OperationalTile.class.getPackage().getName() + ".";

    private String resource;
    private int token;

    public OperationalTile(String resource) {
        this.resource = resource;
    }

     public static OperationalTile createOperationalTileFromStringResource(String operationalTile) {
        try {
                Class<? extends  OperationalTile> cls = (Class<? extends OperationalTile>) Class.forName(pack + operationalTile);
                return cls.newInstance();
        }  catch (ClassNotFoundException CNFE) {
            CNFE.printStackTrace();
            throw new IllegalArgumentException("No class found for the resource " + operationalTile);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
     }

    public void distribute() {
        for (int i = 0; i < getConstructions().length; i++) {
            for (int j = 0; j < getConstructions()[i].length; j++) {
                Construction constructionAux = getConstructions()[i][j];
                if (constructionAux != null) {
                    getConstructions()[i][j].produceResources(resource);
                }
            }
        }
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getToken() {
        return token;
    }

    public String getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
