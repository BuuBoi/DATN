package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.CartItemDao;
import com.dnanh01.backend.model.domain.CartItem;

@Repository
public class HibernateCartItemDao extends AbstractSoftDeleteHibernateDao<CartItem> implements CartItemDao {

    public HibernateCartItemDao() {
        super(CartItem.class);
    }

    // Implement additional CartItem-specific methods here if needed

}
