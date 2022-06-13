package com.company.Construction;

import com.company.Engine.Player;

import java.util.HashMap;

public class Fortress extends Construction{
    private static HashMap<String, Integer> costOfFortress;

    static {
        costOfFortress = new HashMap<>();
        costOfFortress.put("Wood", 2);
        costOfFortress.put("Brick", 2);
        costOfFortress.put("Stone", 3);
    }

    public Fortress(Player player) {
        super(player, costOfFortress, 3);
    }
}