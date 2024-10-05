package com.dnanh01.backend.dao.impl;

import org.springframework.stereotype.Repository;

import com.dnanh01.backend.dao.AbstractSoftDeleteHibernateDao;
import com.dnanh01.backend.dao.iface.MessageDao;
import com.dnanh01.backend.model.domain.Message;

@Repository
public class HibernateMessageDao extends AbstractSoftDeleteHibernateDao<Message> implements MessageDao {

    public HibernateMessageDao() {
        super(Message.class);
    }

    // Implement additional Message-specific methods here if needed

}
