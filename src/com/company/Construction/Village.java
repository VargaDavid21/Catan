package com.company.Construction;

import com.company.Engine.Player;

import java.util.HashMap;

public class Village extends Construction{
    private static HashMap<String, Integer> villageCost;

    // static block constructor which initializes the parameters of the class
    static {
        villageCost = new HashMap<>();
        villageCost.put("Wood", 1);
        villageCost.put("Brick", 1);
        villageCost.put("Sheep", 1);
        villageCost.put("Wheat", 1);
    }

    public Village(Player player) {
        super(player, villageCost, 1);
    }
}