package com.dnanh01.backend.dto.response;


import com.dnanh01.backend.model.domain.Address;
import lombok.Data;

@Data
public class AddressResponseDto {
    private String id; // ID của địa chỉ
    private String province;
    private String district;
    private String ward;
    private String details;

    public AddressResponseDto(Address address) {
        this.id = address.getId().toString();
        this.province = address.getProvince();
        this.district = address.getDistrict();
        this.ward = address.getWard();
        this.details = address.getDetails();

    }
}

