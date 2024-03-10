package com.example.ms.company.service;

import com.example.ms.company.dao.repository.CompanyRepository;
import com.example.ms.company.exception.NotFoundException;
import com.example.ms.company.model.request.CreateCompanyRequestDto;
import com.example.ms.company.model.response.CompanyResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.ms.company.mapper.CompanyMapper.COMPANY_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;
    public void createCompany(CreateCompanyRequestDto request){
        log.info("ActionLog.CompanyServiceImpl.createCompany.start request:{}", request);
        companyRepository.save(COMPANY_MAPPER.buildCompanyEntity(request));
    }

    public CompanyResponseDto getCompany(Long id){
        log.info("ActionLog.CompanyServiceImpl.getCompany.start id:{}", id);
        return findCompanyById(id);
    }

    public void updateCompany(Long id, String name){
        log.info("ActionLog.CompanyServiceImpl.updateCompany.start id:{}", id);
        CompanyResponseDto company = findCompanyById(id);
        company.setName(name);
    }

    private CompanyResponseDto findCompanyById(Long id){
        return companyRepository.findById(id)
                .map(COMPANY_MAPPER::buildCompanyResponse)
                .orElseThrow(() -> new NotFoundException("Company Not Found with id: "+ id));
    }
}
