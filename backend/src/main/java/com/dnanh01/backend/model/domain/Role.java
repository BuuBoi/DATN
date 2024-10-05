package com.dnanh01.backend.model.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "roles")
public class Role extends BaseClazz {

	@Column(name = "role_name", nullable = false, unique = true)
	private String roleName;

	/**
	 * relationship
	 * 1-n [role_permissions]
	 * 1-n [users]
	 *
	 * @author DNAnh01[Do Nguyen Anh]
	 */
	@Builder.Default
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "role_permissions")
	private Set<RolePermission> rolePermissions = new HashSet<>();

	@Builder.Default
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "users")
	private List<User> users = new ArrayList<>();
}
