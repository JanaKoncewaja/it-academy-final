package com.it.academy.webapp.model;

import com.it.academy.domain.sensor.TemperatureSensor;

import java.util.Objects;

public class TemperatureCatalogPageItem {

    private final TemperatureSensor sensor;
    private final String deviceName;

    public TemperatureCatalogPageItem(TemperatureSensor sensor, String deviceName) {
        this.sensor = sensor;
        this.deviceName = deviceName;
    }

    public TemperatureSensor getSensor() {
        return sensor;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureCatalogPageItem that = (TemperatureCatalogPageItem) o;
        return Objects.equals(sensor, that.sensor) &&
                Objects.equals(deviceName, that.deviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensor, deviceName);
    }
}
