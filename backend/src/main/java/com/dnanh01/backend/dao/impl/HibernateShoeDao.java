package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.ShoeDao;
import com.dnanh01.backend.model.domain.Shoe;

@Repository
public class HibernateShoeDao extends AbstractSoftDeleteHibernateDao<Shoe> implements ShoeDao {

    public HibernateShoeDao() {
        super(Shoe.class);
    }

    // Implement additional Shoe-specific methods here if needed

}
