package com.company.Construction;

import com.company.Engine.Player;

import java.util.HashMap;

public class City extends Construction {
    private static HashMap<String, Integer> costOfCity;

    static {
        costOfCity = new HashMap<>();
        costOfCity.put("Wheat", 2);
        costOfCity.put("Stone", 3);
    }

    public City(Player player) {
        super(player, costOfCity, 2);
    }
}