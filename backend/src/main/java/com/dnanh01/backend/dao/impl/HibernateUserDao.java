package com.dnanh01.backend.dao.impl;

import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.UserDao;
import com.dnanh01.backend.model.domain.User;

import java.util.Optional;

@Repository
public class HibernateUserDao extends AbstractSoftDeleteHibernateDao<User> implements UserDao {

    public HibernateUserDao() {
        super(User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(getCurrentSession().createQuery("FROM User WHERE email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult());
    }


}
