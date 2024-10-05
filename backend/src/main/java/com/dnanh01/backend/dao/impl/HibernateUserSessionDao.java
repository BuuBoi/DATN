package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.UserSessionDao;
import com.dnanh01.backend.model.domain.UserSession;

@Repository
public class HibernateUserSessionDao extends AbstractSoftDeleteHibernateDao<UserSession> implements UserSessionDao {

    public HibernateUserSessionDao() {
        super(UserSession.class);
    }

    // Implement additional UserSession-specific methods here if needed

}
