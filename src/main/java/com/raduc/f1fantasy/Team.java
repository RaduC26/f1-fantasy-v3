package com.raduc.f1fantasy;

public class Team {
    private final String name;
    private Double price;
    private Double points;

    public Team(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getPoints() {
        return points;
    }
}
