package com.company.Resource;

public abstract class Resource {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}