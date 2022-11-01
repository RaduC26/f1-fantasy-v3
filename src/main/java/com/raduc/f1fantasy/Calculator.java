package com.raduc.f1fantasy;

import java.util.List;

public class Calculator {
    private List<Driver> drivers;

    public void createDrivers() {
        drivers.add(new Driver("Lewis Hamilton", 22.3));
        drivers.add(new Driver("Max Verstappen", 34.1));
        drivers.add(new Driver("Lewis Hamilton", 22.3));
        drivers.add(new Driver("Lewis Hamilton", 22.3));
        drivers.add(new Driver("Lewis Hamilton", 22.3));
        drivers.add(new Driver("Lewis Hamilton", 22.3));
    }
}
