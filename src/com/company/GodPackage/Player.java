package com.company.GodPackage;

import com.company.Construction.Construction;
import com.company.Resource.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Player {
    private static int id = 0;

    private String name;
    private String color;
    private Construction construction;
    private ArrayList<Construction> constructions;
    private HashMap<Resource, Integer> resources;

    public Player(String name) {
        this.name = name;
        Random r = new Random();
        String[] colorsArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        int randomNumber = r.nextInt(colorsArray.length);
        this.color = colorsArray[randomNumber];
        id++;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Construction getConstruction() {
        return construction;
    }

    public ArrayList<Construction> getConstructions() {
        return constructions;
    }

    @Override
    public String toString() {
        return "";
    }
}