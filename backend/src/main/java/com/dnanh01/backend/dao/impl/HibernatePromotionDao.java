package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.PromotionDao;
import com.dnanh01.backend.model.domain.Promotion;

@Repository
public class HibernatePromotionDao extends AbstractSoftDeleteHibernateDao<Promotion> implements PromotionDao {

    public HibernatePromotionDao() {
        super(Promotion.class);
    }

    // Implement additional Promotion-specific methods here if needed

}
