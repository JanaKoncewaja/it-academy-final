package com.it.academy.data.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@MappedSuperclass
public abstract class SensorEntity implements Serializable, MarkerInt {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_entity_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    List<DeviceEntity> deviceEntities;


    public SensorEntity(String name, List<DeviceEntity> deviceEntities) {
        this.name = name;
        this.deviceEntities = deviceEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeviceEntity> getDeviceEntities() {
        return deviceEntities;
    }

    public void setDeviceEntities(List<DeviceEntity> deviceEntities) {
        this.deviceEntities = deviceEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorEntity that = (SensorEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(deviceEntities, that.deviceEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deviceEntities);
    }
}

