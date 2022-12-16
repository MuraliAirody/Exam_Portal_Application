package com.exam.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private int roleId;
    private String rolename;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();
    public Role() {
    }

    public Role(int roleId, String rolename) {
        this.roleId = roleId;
        this.rolename = rolename;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
