package com.it.academy.data.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "temperature_sensor")
public class TemperatureSensorEntity extends AbstractSensorEntity implements Serializable,MarkerInt {

    @Column(name = "value")
    private Double value;

    public TemperatureSensorEntity(String name, DeviceEntity device) {
        super(name, device);
    }

    public TemperatureSensorEntity(String name, DeviceEntity device, Double value) {
        super(name, device);
        this.value = value;
    }

    public TemperatureSensorEntity() {
    }


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TemperatureSensorEntity that = (TemperatureSensorEntity) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
