package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.ShoePromotionDao;
import com.dnanh01.backend.model.domain.ShoePromotion;

@Repository
public class HibernateShoePromotionDao extends AbstractSoftDeleteHibernateDao<ShoePromotion>
        implements ShoePromotionDao {

    public HibernateShoePromotionDao() {
        super(ShoePromotion.class);
    }

    // Implement additional ShoePromotion-specific methods here if needed

}
