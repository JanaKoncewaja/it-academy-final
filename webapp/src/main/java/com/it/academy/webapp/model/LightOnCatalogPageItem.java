package com.it.academy.webapp.model;

import com.it.academy.domain.sensor.LightOnSensor;

import java.util.Objects;

public class LightOnCatalogPageItem {

    private final LightOnSensor sensor;
    private final String deviceName;

    public LightOnCatalogPageItem(LightOnSensor sensor, String deviceName) {
        this.sensor = sensor;
        this.deviceName = deviceName;
    }

    public LightOnSensor getSensor() {
        return sensor;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightOnCatalogPageItem that = (LightOnCatalogPageItem) o;
        return Objects.equals(sensor, that.sensor) &&
                Objects.equals(deviceName, that.deviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensor, deviceName);
    }
}
