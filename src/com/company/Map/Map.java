package com.company.Map;
import com.company.Engine.Coordinates;
import com.company.Engine.Game;
import com.company.Engine.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private int thiefIndex;
    private Tile[][][] tiles;
    private HashMap<Integer, ArrayList<OperationalTile>> tokenHashMap = new HashMap<>();

    public Map(int numberOfTilesOnEdge) {
        if (numberOfTilesOnEdge < 3) {
            throw new IllegalArgumentException("You cannot make a map with less than 3 tiles on the edge.");
        }

        int numberOfTilesOnDiagonals = 2 * numberOfTilesOnEdge - 1;
        int totalTiles = 3 * numberOfTilesOnEdge * numberOfTilesOnEdge - 3 * numberOfTilesOnEdge + 1;
        int totalConstructionNodes = 6 * numberOfTilesOnEdge * numberOfTilesOnEdge;
        int totalRoadNodes = 9 * numberOfTilesOnEdge * numberOfTilesOnEdge - 3 * numberOfTilesOnEdge;
        int numberOfDeserts = (int) Math.round(0.05 * totalTiles);

        tiles = new Tile[numberOfTilesOnDiagonals][numberOfTilesOnDiagonals][numberOfTilesOnDiagonals];
        ArrayList<Tile> initialTileSet = new ArrayList<>();
        ArrayList<Integer> initialTokensList = new ArrayList<>();

        int R = totalTiles - numberOfDeserts;
        int Rc = R / OperationalTile.OPERATIONAL_TILE_TYPES.length;
        int Rr = R % OperationalTile.OPERATIONAL_TILE_TYPES.length;

        for (int i = 0; i < Rr; i++) {
            boolean flag = false;
            do {
                OperationalTile operationalTile = OperationalTile.createOperationalTileFromStringResource(OperationalTile.OPERATIONAL_TILE_TYPES[(int) (Math.random() * OperationalTile.OPERATIONAL_TILE_TYPES.length)]);
                if (!initialTileSet.contains(operationalTile)) {
                    initialTileSet.add(operationalTile);
                    flag = true;
                }
            } while (!flag);
        }

        for (int i = 0; i < numberOfDeserts; i++) {
            int thiefRandomNumber = (int)(Math.random()*numberOfDeserts);
            Desert desert = new Desert();
            if (i == thiefRandomNumber) {
                desert.setHasThief(true);
            }
            initialTileSet.add(desert);
        }

        for (int i = 0; i < OperationalTile.OPERATIONAL_TILE_TYPES.length; i++) {
            for (int j = 0; j < Rc; j++) {
                OperationalTile operationalTile = OperationalTile.createOperationalTileFromStringResource(OperationalTile.OPERATIONAL_TILE_TYPES[i]);
                initialTileSet.add(operationalTile);
            }
        }

        int J1 = (int) Math.ceil((double) 3 * R / 21);
        int J2 = (int) Math.ceil((double) 2 * R / 21);
        int aux = R - 2 * J1 - 4 * J2;
        int J3c =  aux / 4;
        int J3r = aux % 4;

        for (int g : Game.TOKEN_TYPES) {
            tokenHashMap.put(g, new ArrayList<>());
        }

        int[] randomRemainingTokens = {Game.TOKEN_TYPES[0], Game.TOKEN_TYPES[1], Game.TOKEN_TYPES[8], Game.TOKEN_TYPES[9]};

        for (int i = 0; i < J3r; i++) {
            boolean flag = false;
            do {
                int randomToken = randomRemainingTokens[(int)(Math.random()*randomRemainingTokens.length)];
                if (!initialTokensList.contains(randomToken)) {
                    initialTokensList.add(randomToken);
                    flag = true;
                }
            } while (!flag);
        }

        for (int i = 0; i < J1; i++) {
            initialTokensList.add(Game.TOKEN_TYPES[4]);
            initialTokensList.add(Game.TOKEN_TYPES[5]);
        }

        for (int i = 0; i < J2; i++) {
            initialTokensList.add(Game.TOKEN_TYPES[2]);
            initialTokensList.add(Game.TOKEN_TYPES[3]);
            initialTokensList.add(Game.TOKEN_TYPES[6]);
            initialTokensList.add(Game.TOKEN_TYPES[7]);
        }

        for (int i = 0; i < J3c; i++) {
            initialTokensList.add(Game.TOKEN_TYPES[0]);
            initialTokensList.add(Game.TOKEN_TYPES[1]);
            initialTokensList.add(Game.TOKEN_TYPES[8]);
            initialTokensList.add(Game.TOKEN_TYPES[9]);
        }

        System.out.println(initialTileSet.size() + " | " + initialTokensList.size());
        System.out.println(numberOfDeserts);

        if (initialTileSet.size() != (initialTokensList.size() + numberOfDeserts)) {
            throw new IllegalStateException("Number of tokens different than number of tiles.");
        }

        initiateMap(initialTileSet, initialTokensList);
    }

    public void initiateMap(ArrayList<Tile> initialTileSet, ArrayList<Integer> initialTokenList) {
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                for (int z = 0; z < tiles[x][y].length; z++) {
                    if (- x - y + z == - 3) {
                        Tile randomTile = initialTileSet.remove((int)(Math.random()* initialTileSet.size()));
                        if (randomTile instanceof OperationalTile) {
                            int randomToken = initialTokenList.remove((int) (Math.random() * initialTokenList.size()));
                            ArrayList<OperationalTile> operationalTileArrayListAux = tokenHashMap.get(randomToken);
                            operationalTileArrayListAux.add((OperationalTile) randomTile);
                            tokenHashMap.replace(randomToken, operationalTileArrayListAux);
                            ((OperationalTile) randomTile).setToken(randomToken);
                        }
                        System.out.println(initialTokenList + "  |  " + initialTileSet);
                        tiles[x][y][z] = randomTile;
                    }
                }
            }
        }
    }

    public void distributeResourcesForDice(int diceValue) {
        for (OperationalTile o : tokenHashMap.get(diceValue)) {
            o.distribute();
        }
    }

    public int getThiefIndex() {
        return thiefIndex;
    }

    public void setThiefIndex(int thiefIndex) {
        this.thiefIndex = thiefIndex;
    }

    public void moveThief(Coordinates coordinates) {
        if (coordinates.getX() < 0 || coordinates.getX() > 2 || coordinates.getY() < 0 || coordinates.getY() > 6) throw new IllegalArgumentException("Cannot place thief there.");

    }

    @Override
    public String toString() {
        String aux = "Map \n" + "N = " + (tiles.length + 1)/2 + "\n ";
            for (int i = 0; i < tiles.length; i++) {
                for (int j = 0; j < tiles.length; j++) {
                    for (int k = 0; k < tiles.length; k++) {
                        if (tiles[i][j][k] != null) {
                            aux += tiles[i][j][k].toString() + " ";
                        }
                    }
                }
                aux += "\n";
            }
    return aux;
    }
}