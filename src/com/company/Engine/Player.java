package com.company.Engine;

import com.company.Construction.Construction;
import com.company.Map.OperationalTile;
import com.company.Resource.Resource;

import java.util.*;

public class Player {
    public static final String[] PLAYER_COLORS = {"Blue", "Red", "Green", "Yellow", "Purple", "Orange", "Cyan", "Brown"};
    private static int nrOfPlayer = 0;

    private int id;
    private String name;
    private String color;
    private LinkedHashMap<String, Integer> resources;
    private LinkedHashMap<String, Integer> constructions;
    private int winningPoints;

    public void addResource(String resource, int howMany) {
        if (howMany < 0) throw new IllegalArgumentException("Cannot add 0 or lower resources. ");
        resources.replace(resource, howMany + resources.get(resource));
    }

    public void removeResource(String resource, int howMany) {
        if (howMany <= 0) throw new IllegalArgumentException("Cannot remove 0 or lower resources. ");
        int aux = resources.get(resource) - howMany;
        if (aux < 0) { throw new IllegalArgumentException("Not enough resources of this type. "); }
        resources.replace(resource, aux);
    }

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        resources = new LinkedHashMap<>();
        for(String r : Resource.RESOURCE_TYPES) {
            resources.put(r, 0);
        }
        constructions = new LinkedHashMap<>();
        for(String c : Construction.CONSTRUCTION_TYPES) {
            constructions.put(c, 0);
        }
        this.id = ++nrOfPlayer;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public LinkedHashMap<String, Integer> getResources() {
        return resources;
    }

    public LinkedHashMap<String, Integer> getConstruction() {
        return constructions;
    }

    public void addConstructions(String construction) {
        constructions.replace(construction, constructions.get(construction) + 1);
    }

    @Override
    public String toString() {
        String aux = "PLAYER " + id + "\nName: " + name + "\nColor: " + color + "\nResources:\n";
        for(Map.Entry<String, Integer> resource : resources.entrySet()) {
            aux += resource.getKey() + ": " + resource.getValue() + "\t";
        }
        aux+="\nConstructions:\n";
        for(Map.Entry<String, Integer> construction : constructions.entrySet()) {
            aux += construction.getKey() + ": " + construction.getValue() + "\t";
        }
        return aux +"\n\n";
    }
}