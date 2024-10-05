package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.CartDao;
import com.dnanh01.backend.model.domain.Cart;

@Repository
public class HibernateCartDao extends AbstractSoftDeleteHibernateDao<Cart> implements CartDao {

    public HibernateCartDao() {
        super(Cart.class);
    }

    // Implement additional Cart-specific methods here if needed

}
