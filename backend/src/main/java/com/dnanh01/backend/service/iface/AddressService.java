package com.dnanh01.backend.service.iface;

import com.dnanh01.backend.dto.request.AddressCreateRequestDto;
import com.dnanh01.backend.dto.request.AddressUpdateOrDeleteDto;
import com.dnanh01.backend.dto.response.AddressResponseDto;

import java.util.List;
import java.util.Set;

public interface AddressService {
    AddressResponseDto createAddress(String userId, AddressCreateRequestDto addressCreateRequestDto);

    AddressResponseDto getAddress(String addressId);

    AddressResponseDto updateAddress(String addressId, AddressUpdateOrDeleteDto addressUpdateOrDeleteDto);

    void deleteAddress(String addressId);

    List<AddressResponseDto> getAllAddressesByUserId();
}
