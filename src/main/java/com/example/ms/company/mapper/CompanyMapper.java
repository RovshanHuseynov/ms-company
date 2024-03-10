package com.example.ms.company.mapper;

import com.example.ms.company.dao.entity.CompanyEntity;
import com.example.ms.company.model.request.CreateCompanyRequestDto;
import com.example.ms.company.model.response.CompanyResponseDto;

import static com.example.ms.company.model.enums.CompanyStatus.ACTIVE;

public enum CompanyMapper {
    COMPANY_MAPPER;

    public CompanyEntity buildCompanyEntity(CreateCompanyRequestDto companyDto){
        return CompanyEntity.builder()
                .name(companyDto.getName())
                .status(ACTIVE)
                .build();
    }

    public CompanyResponseDto buildCompanyResponse(CompanyEntity companyEntity){
        return CompanyResponseDto.builder()
                .id(companyEntity.getId())
                .name(companyEntity.getName())
                .build();
    }
}
