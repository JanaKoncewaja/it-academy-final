package com.it.academy.domain.sensor;

public class TemperatureSensor implements Sensor<Double> {

    private final Long id;
    private final String name;
    private final Double value;

    public TemperatureSensor(Long id, String name, Double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    @Override
    public Long id() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public Double value() {
        return null;
    }
}
