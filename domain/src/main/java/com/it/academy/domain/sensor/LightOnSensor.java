package com.it.academy.domain.sensor;

import java.util.Objects;

public class LightOnSensor implements Sensor<Boolean> {

    private final Long id;
    private final String name;
    private final Boolean value;

    public LightOnSensor(Long id, String name, Boolean value) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
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

    @Override
    public String
    toString() {
        return "LightOnSensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightOnSensor that = (LightOnSensor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
