package com.dataindev.dashboard.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "permissions")
public class Permission {

    @Id
    private long id;

    private String permissionName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "permission" )
    private Set<UserPermissions> userPermission = new HashSet<>();
}
