package org.example.epam.entity;

public class Ship {
    private final long weightToLoad;
    private final long weightToUnload;
    private final String name;

    public Ship(String name, long weightToLoad, long weightToUnload) {
        this.weightToLoad = weightToLoad;
        this.weightToUnload = weightToUnload;
        this.name = name;
    }

    public long getWeightToLoad() {
        return weightToLoad;
    }

    public long getWeightToUnload() {
        return weightToUnload;
    }

    public String getName() {
        return name;
    }
}
