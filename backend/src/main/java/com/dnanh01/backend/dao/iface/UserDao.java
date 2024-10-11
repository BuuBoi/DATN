package com.dnanh01.backend.dao.iface;

import com.dnanh01.backend.dao.iface.common.GenericDao;
import com.dnanh01.backend.dao.iface.common.SoftDeleteDao;
import com.dnanh01.backend.model.domain.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User>, SoftDeleteDao<User> {
    Optional<User> findByEmail(String email);
}
