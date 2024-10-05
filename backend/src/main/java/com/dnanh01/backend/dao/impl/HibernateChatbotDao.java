package com.dnanh01.backend.dao.impl;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.ChatbotDao;
import com.dnanh01.backend.model.domain.Chatbot;

public class HibernateChatbotDao extends AbstractSoftDeleteHibernateDao<Chatbot> implements ChatbotDao {

    public HibernateChatbotDao() {
        super(Chatbot.class);
    }

    // Implement additional Chatbot-specific methods here if needed

}
