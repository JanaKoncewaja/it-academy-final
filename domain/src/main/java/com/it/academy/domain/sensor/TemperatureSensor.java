package com.it.academy.domain.sensor;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "TemperatureSensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureSensor that = (TemperatureSensor) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value);
    }
}
