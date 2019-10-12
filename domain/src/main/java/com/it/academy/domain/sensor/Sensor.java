package com.it.academy.domain.sensor;

public interface Sensor<T> {
    Long id();
    String name();
    T value();
}
