package com.dnanh01.backend.dao.iface;

import com.dnanh01.backend.model.domain.Role;

public interface RoleDao {
    Role createRole(String roleName);
    Role findRole(String roleName);
}