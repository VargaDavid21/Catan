package com.company.Construction;

import com.company.GodPackage.Player;
import com.company.Resource.Bricks;
import com.company.Resource.Resource;
import com.company.Resource.Wood;

import java.util.HashMap;

public class MudRoad extends Construction{
    private HashMap<Resource, Integer> cost;

    public MudRoad(Player player, int cordX, int cordY) {
        super(player, cordX, cordY, 1);
        HashMap<Resource, Integer> cost = new HashMap<>(0);
        cost.put(new Wood(), 1);
        cost.put(new Bricks(), 1);
    }
}
