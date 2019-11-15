package com.it.academy.domain.user;

import java.util.Objects;

public class AppRole {

    private final Long id;
    private final RoleName roleName;

    public AppRole(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppRole appRole = (AppRole) o;
        return Objects.equals(id, appRole.id) &&
                roleName == appRole.roleName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName);
    }
}
