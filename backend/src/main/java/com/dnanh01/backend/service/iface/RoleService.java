package com.dnanh01.backend.service.iface;

import com.dnanh01.backend.model.domain.Role;

public interface RoleService {
    Role createRole(String roleName);
    Role findRole(String roleName);
}
