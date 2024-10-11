package com.dnanh01.backend.service.impl;

import com.dnanh01.backend.dao.iface.RoleDao;
import com.dnanh01.backend.dao.impl.HibernateRoleDao;
import com.dnanh01.backend.model.domain.Role;
import com.dnanh01.backend.service.iface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role createRole(String roleName) {
       return roleDao.createRole(roleName);
    }

    @Override
    public Role findRole(String roleName) {
        return roleDao.findRole(roleName);
    }


}