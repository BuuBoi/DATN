package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.ColorDao;
import com.dnanh01.backend.model.domain.Color;

@Repository
public class HibernateColorDao extends AbstractSoftDeleteHibernateDao<Color> implements ColorDao {

    public HibernateColorDao() {
        super(Color.class);
    }

    // Implement additional Color-specific methods here if needed

}
