package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.OrderDao;
import com.dnanh01.backend.model.domain.Order;

@Repository
public class HibernateOrderDao extends AbstractSoftDeleteHibernateDao<Order> implements OrderDao {

    public HibernateOrderDao() {
        super(Order.class);
    }

    // Implement additional Order-specific methods here if needed

}
