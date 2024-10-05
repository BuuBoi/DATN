package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.OrderItemDao;
import com.dnanh01.backend.model.domain.OrderItem;

@Repository
public class HibernateOrderItemDao extends AbstractSoftDeleteHibernateDao<OrderItem> implements OrderItemDao {

    public HibernateOrderItemDao() {
        super(OrderItem.class);
    }

    // Implement additional OrderItem-specific methods here if needed

}
