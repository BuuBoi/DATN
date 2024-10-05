package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.KnowledgeBaseDao;
import com.dnanh01.backend.model.domain.KnowledgeBase;

@Repository
public class HibernateKnowledgeBaseDao extends AbstractSoftDeleteHibernateDao<KnowledgeBase>
        implements KnowledgeBaseDao {

    public HibernateKnowledgeBaseDao() {
        super(KnowledgeBase.class);
    }

    // Implement additional KnowledgeBase-specific methods here if needed

}
