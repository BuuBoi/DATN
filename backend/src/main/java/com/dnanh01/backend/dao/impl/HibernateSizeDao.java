package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.SizeDao;
import com.dnanh01.backend.model.domain.Size;

@Repository
public class HibernateSizeDao extends AbstractSoftDeleteHibernateDao<Size> implements SizeDao {

    public HibernateSizeDao() {
        super(Size.class);
    }

    // Implement additional Size-specific methods here if needed

}
