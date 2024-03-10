package com.example.ms.company.service;

import com.example.ms.company.model.request.CreateCompanyRequestDto;
import com.example.ms.company.model.response.CompanyResponseDto;

public interface CompanyService {
    void createCompany(CreateCompanyRequestDto company);

    CompanyResponseDto getCompany(Long id);

    void updateCompany(Long id, String name);
}
