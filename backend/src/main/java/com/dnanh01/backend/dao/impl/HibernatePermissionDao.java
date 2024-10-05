package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.PermissionDao;
import com.dnanh01.backend.model.domain.Permission;

@Repository
public class HibernatePermissionDao extends AbstractSoftDeleteHibernateDao<Permission> implements PermissionDao {

    public HibernatePermissionDao() {
        super(Permission.class);
    }

    // Implement additional Permission-specific methods here if needed

}
