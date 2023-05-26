package de.oliver.algorithms;

public abstract class Algorithm {

    private final String name;
    private final String timeComplexity;

    public Algorithm(String name, String timeComplexity){
        this.name = name;
        this.timeComplexity = timeComplexity;
    }

    public String getName() {
        return name;
    }

    public String getTimeComplexity() {
        return timeComplexity;
    }
}
