package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.RoleDao;
import com.dnanh01.backend.model.domain.Role;

@Repository
public class HibernateRoleDao extends AbstractSoftDeleteHibernateDao<Role> implements RoleDao {

    public HibernateRoleDao() {
        super(Role.class);
    }

    // Implement additional Role-specific methods here if needed

}
