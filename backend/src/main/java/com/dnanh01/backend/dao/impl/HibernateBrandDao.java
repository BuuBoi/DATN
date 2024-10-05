package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.BrandDao;
import com.dnanh01.backend.model.domain.Brand;

@Repository
public class HibernateBrandDao extends AbstractSoftDeleteHibernateDao<Brand> implements BrandDao {

    public HibernateBrandDao() {
        super(Brand.class);
    }

    // Implement additional Brand-specific methods here if needed

}
