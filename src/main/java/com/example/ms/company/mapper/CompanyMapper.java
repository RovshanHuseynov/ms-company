package com.example.ms.company.mapper;

import com.example.ms.company.model.request.CreateCompanyRequestDto;
import com.example.ms.company.dao.entity.CompanyEntity;

public enum CompanyMapper {
    COMPANY_MAPPER;

    public CompanyEntity buildCompanyEntity(CreateCompanyRequestDto companyDto){
        return CompanyEntity.builder()
                .name(companyDto.getName())
                .build();
    }
}
