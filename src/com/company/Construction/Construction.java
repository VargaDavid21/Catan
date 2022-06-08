package com.company.Construction;

import com.company.Engine.Player;
import com.company.Resource.Resource;

import java.util.HashMap;

public abstract class Construction {

    public static final String[] CONSTRUCTION_TYPES = {"Village", "City", "Fortress", "MudRoad", "StoneRoad"};
    private int points;
    private int cordX;
    private int cordY;

    private Player player;
    private HashMap<Resource, Integer> cost;

    public Construction(Player player) {
        this.player = player;
        this.cordX = cordX;
        this.cordY = cordY;
    }

    public int getPoints() {
        return points;
    }

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public Player getPlayer() {
        return player;
    }

    public HashMap<Resource, Integer> getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Construction{" +
                "points=" + points +
                ", cordX=" + cordX +
                ", cordY=" + cordY +
                ", player=" + player +
                ", cost=" + cost +
                '}';
    }
}