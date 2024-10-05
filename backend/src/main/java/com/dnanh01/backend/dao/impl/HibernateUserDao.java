package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.UserDao;
import com.dnanh01.backend.model.domain.User;

@Repository
public class HibernateUserDao extends AbstractSoftDeleteHibernateDao<User> implements UserDao {

    public HibernateUserDao() {
        super(User.class);
    }

    // Implement additional User-specific methods here if needed

}
