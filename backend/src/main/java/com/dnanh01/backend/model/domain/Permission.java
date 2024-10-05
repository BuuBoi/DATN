package com.dnanh01.backend.model.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "permissions")
public class Permission extends BaseClazz {

    @Column(name = "permission_name", nullable = false, unique = true)
    private String permissionName;

    /**
     * relationship
     * 1-n [role_permissions]
     *
     * @author DNAnh01[Do Nguyen Anh]
     */
    @Builder.Default
    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "role_permissions")
    private Set<RolePermission> rolePermissions = new HashSet<>();
}
