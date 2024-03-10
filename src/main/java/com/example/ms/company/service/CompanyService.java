package com.example.ms.company.service;

import com.example.ms.company.model.request.CreateCompanyRequestDto;
import com.example.ms.company.model.response.CompanyResponseDto;

import java.util.List;

public interface CompanyService {
    void createCompany(CreateCompanyRequestDto company);

    CompanyResponseDto getCompany(Long id);

    List<CompanyResponseDto> getCompanies();

    void updateCompany(Long id, String name);

    void deleteCompany(Long id);
}
