package com.it.academy.domain.sensor;

public abstract class Sensor<T> {
    Long id;
    String name;
    T value;
}
