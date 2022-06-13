package com.company.Engine;

import com.company.Construction.Construction;
import com.company.Construction.Fortress;
import com.company.Map.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Game {
    public static final int[] TOKEN_TYPES = {2, 3, 4, 5, 6, 8, 9, 10, 11, 12};

    private static final String[] PLAYERS = {"Denis", "Menis", "Benis", "Tenis", "Fenis", "Penis"};
    private Map map;
    private LinkedList<Player> playerLinkedList;
    private int maxScore;
    private Player winner;

    public Game(int numberOfTilesOnEdge, int nrOfPlayers, int maxScore) {
        this.map = new Map(numberOfTilesOnEdge);
        this.playerLinkedList = new LinkedList<>();

        ArrayList<String> remainingPlayerColors = new ArrayList<>(Arrays.asList(Player.PLAYER_COLORS));
        for(int i = 0; i < nrOfPlayers; i++) {
            String randomPlayerName = PLAYERS[(int)(Math.random()*PLAYERS.length)];
            String randomColor = remainingPlayerColors.remove((int)(Math.random()*remainingPlayerColors.size()));
            Player p = new Player(randomPlayerName, randomColor);
            p.addResource("Wheat", 100);
            p.addResource("Stone", 100);
            p.addResource("Sheep", 100);
            p.addResource("Wood", 100);
            p.addResource("Brick", 100);
            Construction construction = Construction.createConstructionFromString(Construction.CONSTRUCTION_TYPES[(int)(Math.random()*Construction.CONSTRUCTION_TYPES.length)]);
            playerLinkedList.add(new Player(randomPlayerName,randomColor));
        }
        this.maxScore = maxScore;
    }

    public void rollDices() {
        int min = 1;
        int max = 6;
        int d1 = (int)(Math.random()*((max - min + 1) + min));
        int d2 = (int)(Math.random()*((max - min + 1) + min));
        int sum = d1 + d2;
        System.out.println("Rolled dice " + sum);
        if (sum != 7) {
        map.distributeResourcesForDice(d1 + d2);
        }
    }

    // for each tile in tiles, see if p is equal to the token of the tile and if the player has a construction there.
    // If so, the tile will generate a resource of the tile's type in the number of the player's construction points
    public void nextRound(Player nextPlayer) {
        nextPlayer = playerLinkedList.get(0);
        while (winner == null) {
            // int diceRoll = rollDices();
            // System.out.println("Dices rolled " + diceRoll + ". ");
        }
    }

    @Override
    public String toString() {
        String aux = "CATAN\n\n";
        for (Player p : playerLinkedList) {
            aux += p;
        }
        return aux;
    }
}