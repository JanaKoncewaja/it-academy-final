package com.it.academy.data.entity;

import com.it.academy.domain.user.RoleName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "approle")
public class AppRoleEntity implements Serializable,MarkerInt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approle_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppRoleEntity that = (AppRoleEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}