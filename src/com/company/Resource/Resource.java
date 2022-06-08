package com.company.Resource;

public abstract class Resource {
    public static final String[] RESOURCE_TYPES = {"Brick", "Sheep", "Stone", "Wheat", "Wood"};
    abstract public String getName();

    @Override
    public boolean equals(Object o) {
        if(o instanceof Resource) {
            return ((Resource)o).getName().equals(getName());
        }
        return false;
    }
}