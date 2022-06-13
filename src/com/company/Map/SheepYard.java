package com.company.Map;

public class SheepYard extends OperationalTile {
    private static String resource = "Sheep";

    public SheepYard() {
        super(resource);
    }

    @Override
    public String toString() {
        return super.toString() + "ShY - " + getToken();
    }
}
