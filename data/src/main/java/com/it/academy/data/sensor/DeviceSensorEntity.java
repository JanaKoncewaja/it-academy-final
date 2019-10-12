package com.it.academy.data.sensor;

import com.it.academy.domain.Device;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@MappedSuperclass
public abstract class DeviceSensorEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "device_sensor_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    List<Device> devices;


    public DeviceSensorEntity(String name, List<Device> devices) {
        this.name = name;
        this.devices = devices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceSensorEntity that = (DeviceSensorEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(devices, that.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, devices);
    }
}

