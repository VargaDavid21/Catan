package com.company.Construction;

import com.company.Engine.Player;

import java.util.HashMap;

public class MudRoad extends Construction{
    private static HashMap<String, Integer> costOfMudRoad;

    static {
        costOfMudRoad = new HashMap<>();
        costOfMudRoad.put("Wood", 1);
        costOfMudRoad.put("Brick", 1);
    }

    public MudRoad(Player player) {
        super(player, costOfMudRoad, 0);
    }
}