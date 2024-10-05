package com.dnanh01.backend.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
@Table(name = "roles_permissions")
public class RolePermission extends BaseClazz {

    /**
     * relationship
     * n-1 [roles]
     * n-1 [permissions]
     *
     * @author DNAnh01[Do Nguyen Anh]
     */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "permission_id")
    private Permission permission;
}
