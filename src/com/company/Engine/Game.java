package com.company.Engine;

import com.company.Map.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Game {
    private static final String[] PLAYERS = {"Varga David", "Meches Sebastian", "Moldovan Alex", "Satana Cartoons", "Emilut Praduitorul", "Alexandra Belica"};
    private Map map;
    private LinkedList<Player> playerLinkedList;
    private int maxScore;

    public Game(int numberOfTilesOnEdge, int nrOfPlayers, int maxScore) {
        this.map = new Map(numberOfTilesOnEdge);
        this.playerLinkedList = new LinkedList<>();

        ArrayList<String> remainingPlayerColors = new ArrayList<>(Arrays.asList(Player.PLAYER_COLORS));
        for(int i=0;i<nrOfPlayers;i++) {
            String randomPlayerName = PLAYERS[(int)(Math.random()*PLAYERS.length)];
            String randomColor = remainingPlayerColors.remove((int)(Math.random()*remainingPlayerColors.size()));
            playerLinkedList.add(new Player(randomPlayerName,randomColor));
        }
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        String aux = "CATAN\n\n";
        for (Player p : playerLinkedList) {
            aux += p;
        }
        return aux;
    }

    public void tradeType1() {

    }

    public void tradeType2() {

    }

    public void tradeType3() {

    }

    public void addConstruction(Player player, int cordX, int cordY) {

    }

    public void upgradeConstruction(Player player, int cordX, int cordY) {

    }

    public int rollDices() {
    //return sum of values of two thrown dices
        return 0;
    }

    public void nextRound() {

    }

    public void showMap(){

    }
    public void showConstructions() {

    }
}