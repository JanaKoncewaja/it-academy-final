package com.it.academy.domain.sensor;

import java.util.Objects;

public class TemperatureSensor extends Sensor<Double> {

    private final Long id;
    private final String name;
    private final Double value;

    public TemperatureSensor(Long id, String name, Double value) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
