package com.it.academy.domain;

import com.it.academy.domain.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Device {

    private Long id;
    private  String name;
    private  String ip;
    private String location;
    private final List<Sensor> sensors = new ArrayList<>(0);

    public Device(Long id, String name, String ip, String location) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.name = name;
        this.ip = ip;
        this.location = location;
    }

    public Device(String name, String ip, String location) {
        this.name = name;
        this.ip = ip;
        this.location = location;
    }

    public Device() {
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
        return Objects.equals(id, device.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
