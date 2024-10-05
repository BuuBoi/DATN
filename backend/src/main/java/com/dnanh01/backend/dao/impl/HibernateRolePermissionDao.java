package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.RolePermissionDao;
import com.dnanh01.backend.model.domain.RolePermission;

@Repository
public class HibernateRolePermissionDao extends AbstractSoftDeleteHibernateDao<RolePermission>
        implements RolePermissionDao {

    public HibernateRolePermissionDao() {
        super(RolePermission.class);
    }

    // Implement additional RolePermission-specific methods here if needed

}
