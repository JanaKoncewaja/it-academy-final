package com.it.academy.domain.sensor;

public class LightOnSensor implements Sensor<Boolean> {

    private final Long id;
    private final String name;
    private final Boolean value;

    public LightOnSensor(Long id, String name, Boolean value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    @Override
    public Long id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Boolean value() {
        return this.value;
    }
}
