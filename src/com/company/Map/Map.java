package com.company.Map;

import com.company.Construction.Construction;
import com.company.Engine.Player;
import com.company.Resource.Resource;

import java.util.ArrayList;

public class Map {
    private Tile[][] tiles;
    private Construction[][] constructions;
    private ArrayList<Resource> resources;
    private ArrayList<Integer> tokens;

    public Map(int numberOfTilesOnEdge) {
        if (numberOfTilesOnEdge <= 3) {
            throw new IllegalArgumentException("You cannot make a map with less than 3 tiles on the edge.");
        }

        int numberOfTilesOnDiagonals = 2 * numberOfTilesOnEdge - 1;
        int totalTiles = 3 * numberOfTilesOnEdge * numberOfTilesOnEdge - numberOfTilesOnEdge + 1;
        int totalConstructionNodes = 6 * numberOfTilesOnEdge * numberOfTilesOnEdge;
        int totalRoadNodes = 9 * numberOfTilesOnEdge * numberOfTilesOnEdge - 3 * numberOfTilesOnEdge;
        int numberOfDeserts = (int)Math.round(0.05 * totalTiles);


        tiles = new Tile[numberOfTilesOnDiagonals][numberOfTilesOnDiagonals];
        ArrayList<Tile> initialTileSet = new ArrayList<>();

        int R = totalTiles - numberOfDeserts;
        int Rc = R / Resource.RESOURCE_TYPES.length;
        int Rr = R % Resource.RESOURCE_TYPES.length;

        for (int i = 0; i < Rr; i++) {
            boolean flag = false;
            do {
                //IMPLEMENTEAZA METODA ASTA IN OperationalTile: createOperationalTileFromStringResource
                OperationalTile operationalTile = OperationalTile.createOperationalTileFromStringResource(Resource.RESOURCE_TYPES[(int)(Math.random()*Resource.RESOURCE_TYPES.length)]);
                if (!initialTileSet.contains(operationalTile)) {
                    initialTileSet.add(operationalTile);
                    flag = true;
                }
            } while (!flag);
        }

        /*
            continuare adaugare tile-uri desert

            for (int i = 0; i <= numberOfDeserts; i++) {
                initialTileSet.add(new Desert());
            }

            continuare adaugare tile-uri Rc x ResourceTypes.length
            for (int i = 0; i < Resource.RESOURCE_TYPES.length; i++) {
                for (int j = 0; j < Rc; j++) {
                    initialTileSet.add(OperationalTile.createOperationalTileFromStringResource(Resource.RESOURCE_TYPES[i]));
                }
            }

        */
    }

    //inside Map class have a HashMap<Integer,ArrayList<Tile>> to map tokens to sets of tiles having that token
    //game rolls dice then calls for map.distributeResources(int), depending on the dice value
    //the void distributeResources(int token) will get the Tile ArrayList value from the HashMap at the key token
    //And for every tile in the ArrayList, it will generate the Resource of that tile for all owners of constructions on that Tile, if constructions that produce resources exist

    @Override
    public String toString() {
        return "";
    }
}