package com.company.Construction;

import com.company.Engine.Player;
import com.company.Map.OperationalTile;

import java.util.HashMap;
import java.util.Map;

public abstract class Construction {
    private String color;
    private Player owner;
    private int points;
    private HashMap<String, Integer> constructionCost;
    private static final String pack = OperationalTile.class.getPackage().getName() + ".";

    public static final String[] CONSTRUCTION_TYPES = {"Village", "City", "Fortress", "MudRoad", "StoneRoad"};

    public static Construction createConstructionFromString(String construction) {
        try {
            Class<? extends  Construction> cls = (Class<? extends Construction>) Class.forName(pack + construction);
            return cls.newInstance();
        }  catch (ClassNotFoundException CNFE) {
            CNFE.printStackTrace();
            throw new IllegalArgumentException("No class found for the construction " + construction);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public Construction(Player owner, HashMap<String, Integer> constructionCost, int points) {
        this.owner = owner;
        this.constructionCost = constructionCost;
        this.points = points;
        owner.addConstructions(toString());
        boolean flag = true;
        for (Map.Entry<String, Integer> entry : this.constructionCost.entrySet()) {
            System.out.println(entry.getKey());
            if (entry.getValue() > owner.getResources().get(entry.getKey())) {
                flag = false;
                break;
            }
        }

        if (flag) {
            for (Map.Entry<String, Integer> entry : this.constructionCost.entrySet()) {
                owner.removeResource(entry.getKey(), entry.getValue());
            }
        } else throw new IllegalStateException("You need more funds. ");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void produceResources(String resource) {
        owner.addResource(resource, points);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}