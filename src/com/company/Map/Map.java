package com.company.Map;

import com.company.Construction.Construction;
import com.company.GodPackage.Player;
import com.company.Resource.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

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
            /* int totalConstructionNodes = 6 * numberOfTilesOnEdge * numberOfTilesOnEdge;
            int totalRoadNodes = 9 * numberOfTilesOnEdge * numberOfTilesOnEdge - 3 * numberOfTilesOnEdge; */
            int numberOfDeserts = (int)Math.round(0.05 * totalTiles);
            int  R = totalTiles - numberOfDeserts;

            // Create tiles[][] and tileArray[]
            Tile[][] tiles = new Tile[numberOfTilesOnDiagonals][numberOfTilesOnDiagonals];
            OperationalTile[] operationalTilesTypes = {new ClayPit(), new Forest(), new Granary(), new SheepYard(), new StoneYard()};
            ArrayList<Tile> initialTileSet = new ArrayList<>();

            int  Rc = R / operationalTilesTypes.length;
            int Rr = R % operationalTilesTypes.length;

            for (int i = 0; i < Rr; i++) {
                boolean flag = false;
                do {
                OperationalTile operationalTile = operationalTilesTypes[(int)(Math.random()*operationalTilesTypes.length)];
                if (!initialTileSet.contains(operationalTile)) {
                    initialTileSet.add(operationalTile);
                    flag = true;
                    }
                } while (!flag);
            }

            for (int i = 0; i <= numberOfDeserts; i++) {
                initialTileSet.add(new Desert());
            }

            for (int i = 0; i < operationalTilesTypes.length; i++) {
                for (int j = 0; j < Rc; j++) {
                    initialTileSet.add(operationalTilesTypes[i]);
                }
            }

            for (int i = 0; i < Rr; i++) {
                initialTileSet.add(operationalTilesTypes[(int)(Math.random()*operationalTilesTypes.length)]);
            }


    }

    public void distribute(Player p) {

    }

    @Override
    public String toString() {
        return "";
    }
}