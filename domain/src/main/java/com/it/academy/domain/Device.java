package com.it.academy.domain;

import com.it.academy.domain.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Device {

    private final Long id;
    private final String name;
    private final String ip;
    private final String location;
    private final List<Sensor> sensors = new ArrayList<>(0);

    public Device(Long id, String name, String ip, String location) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public String getLocation() {
        return location;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", location='" + location + '\'' +
                ", sensors=" + sensors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(id, device.id) &&
                Objects.equals(name, device.name) &&
                Objects.equals(ip, device.ip) &&
                Objects.equals(location, device.location) &&
                Objects.equals(sensors, device.sensors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ip, location, sensors);
    }
}
