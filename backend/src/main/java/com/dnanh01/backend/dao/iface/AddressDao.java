package com.dnanh01.backend.dao.iface;

import com.dnanh01.backend.dao.iface.common.GenericDao;
import com.dnanh01.backend.dao.iface.common.SoftDeleteDao;
import com.dnanh01.backend.model.domain.Address;

public interface AddressDao extends GenericDao<Address>, SoftDeleteDao<Address> {
    // Implement additional Address-specific methods here if needed
}
