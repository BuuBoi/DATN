package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.ConversationDao;
import com.dnanh01.backend.model.domain.Conversation;

@Repository
public class HibernateConversationDao extends AbstractSoftDeleteHibernateDao<Conversation> implements ConversationDao {

    public HibernateConversationDao() {
        super(Conversation.class);
    }

    // Implement additional Conversation-specific methods here if needed

}
