package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.AddressDao;
import com.dnanh01.backend.model.domain.Address;

@Repository
public class HibernateAddressDao extends AbstractSoftDeleteHibernateDao<Address> implements AddressDao {

    public HibernateAddressDao() {
        super(Address.class);
    }

    // Implement additional Address-specific methods here if needed
}