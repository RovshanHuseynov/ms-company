package com.example.ms.company.service;

import com.example.ms.company.dao.repository.CompanyRepository;
import com.example.ms.company.model.request.CreateCompanyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.ms.company.mapper.CompanyMapper.COMPANY_MAPPER;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;
    public void createCompany(CreateCompanyRequestDto companyDto){
        companyRepository.save(COMPANY_MAPPER.buildCompanyEntity(companyDto));
    }
}
