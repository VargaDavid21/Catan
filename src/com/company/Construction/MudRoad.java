package com.company.Construction;

import com.company.Engine.Player;
import com.company.Resource.Brick;
import com.company.Resource.Resource;
import com.company.Resource.Wood;

import java.util.HashMap;

public class MudRoad extends Construction{
    private HashMap<Resource, Integer> cost;

    public MudRoad(Player player) {
        super(player);
        HashMap<Resource, Integer> cost = new HashMap<>(0);
        cost.put(new Wood(), 1);
        cost.put(new Brick(), 1);
    }
}
