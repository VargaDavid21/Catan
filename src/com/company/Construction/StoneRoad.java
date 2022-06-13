package com.company.Construction;

import com.company.Engine.Player;

import java.util.HashMap;

public class StoneRoad extends Construction{
    private static HashMap<String, Integer> costOfStoneRoad;

    static {
        costOfStoneRoad = new HashMap<>();
        costOfStoneRoad.put("Wood", 1);
        costOfStoneRoad.put("Brick", 1);
        costOfStoneRoad.put("Stone", 1);
    }

    public StoneRoad(Player player) {
        super(player, costOfStoneRoad, 1);
    }
}