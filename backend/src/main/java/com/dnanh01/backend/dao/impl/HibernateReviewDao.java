package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.ReviewDao;
import com.dnanh01.backend.model.domain.Review;

@Repository
public class HibernateReviewDao extends AbstractSoftDeleteHibernateDao<Review> implements ReviewDao {

    public HibernateReviewDao() {
        super(Review.class);
    }

    // Implement additional Review-specific methods here if needed

}
