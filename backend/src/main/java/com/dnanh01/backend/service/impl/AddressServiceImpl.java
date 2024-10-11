package com.dnanh01.backend.service.impl;

import com.dnanh01.backend.dao.iface.AddressDao;
import com.dnanh01.backend.dao.iface.UserDao;
import com.dnanh01.backend.dao.impl.HibernateAddressDao;
import com.dnanh01.backend.dao.impl.HibernateUserDao;
import com.dnanh01.backend.dto.request.AddressCreateRequestDto;
import com.dnanh01.backend.dto.request.AddressUpdateOrDeleteDto;
import com.dnanh01.backend.dto.response.AddressResponseDto;
import com.dnanh01.backend.exception.AppException;
import com.dnanh01.backend.exception.ErrorCode;
import com.dnanh01.backend.model.domain.Address;
import com.dnanh01.backend.model.domain.User;
import com.dnanh01.backend.service.iface.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;
    private final UserDao userDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao, HibernateUserDao userDao) {
        this.addressDao = addressDao;
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public AddressResponseDto createAddress(String userId, AddressCreateRequestDto addressCreateRequestDto) {
        User user = userDao.findById(UUID.fromString(userId)).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        Address address = new Address();
        address.setProvince(addressCreateRequestDto.getProvince());
        address.setDistrict(addressCreateRequestDto.getDistrict());
        address.setWard(addressCreateRequestDto.getWard());
        address.setDetails(addressCreateRequestDto.getDetails());
        address.setUser(user);
        address = addressDao.save(address);
        AddressResponseDto addressResponseDto = new AddressResponseDto(address);
        return addressResponseDto;
    }

    @Override
    public AddressResponseDto getAddress(String addressId) {
        return null;
    }

    @Transactional
    @Override
    public AddressResponseDto updateAddress(String addressId, AddressUpdateOrDeleteDto addressUpdateOrDeleteDto) {
        if(!addressId.equals(addressUpdateOrDeleteDto.getId())) {
            throw new AppException(ErrorCode.INVALID_KEY);
        }
        Address address = addressDao.findById(UUID.fromString(addressId)).orElseThrow(() -> new AppException(ErrorCode.ADDRESS_NOT_FOUND));
        address.setProvince(addressUpdateOrDeleteDto.getProvince());
        address.setDistrict(addressUpdateOrDeleteDto.getDistrict());
        address.setWard(addressUpdateOrDeleteDto.getWard());
        address.setDetails(addressUpdateOrDeleteDto.getDetails());
        address = addressDao.update(address);
        AddressResponseDto addressResponseDto = new AddressResponseDto(address);
        return addressResponseDto;
    }

    @Override
    public void deleteAddress(String addressId) {

    }

    @Override
    public List<AddressResponseDto> getAllAddressesByUserId() {
        return null;
    }
}
