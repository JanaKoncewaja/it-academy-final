package com.it.academy.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "light_on_sensor")
public class LightOnSensorEntity extends AbstractSensorEntity implements Serializable,MarkerInt {

    @Column(name = "value")
    private Boolean value;

    public LightOnSensorEntity() {

    }

    public LightOnSensorEntity(String name, DeviceEntity device, Boolean value) {
        super(name, device);
        this.value = value;
    }

    public LightOnSensorEntity(String name, DeviceEntity device) {
        super(name, device);
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightOnSensorEntity that = (LightOnSensorEntity) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
