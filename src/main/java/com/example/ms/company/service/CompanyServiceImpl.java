package com.example.ms.company.service;

import com.example.ms.company.dao.entity.CompanyEntity;
import com.example.ms.company.dao.repository.CompanyRepository;
import com.example.ms.company.exception.NotFoundException;
import com.example.ms.company.model.request.CreateCompanyRequestDto;
import com.example.ms.company.model.response.CompanyResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.ms.company.mapper.CompanyMapper.COMPANY_MAPPER;
import static com.example.ms.company.model.enums.CompanyStatus.DELETED;

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
        return COMPANY_MAPPER.buildCompanyResponse(getCompanyEntityIfExist(id));
    }

    public void updateCompany(Long id, String name){
        log.info("ActionLog.CompanyServiceImpl.updateCompany.start id:{}", id);
        CompanyEntity company = getCompanyEntityIfExist(id);
        company.setName(name);
        companyRepository.save(company);
    }

    public void deleteCompany(Long id){
        log.info("ActionLog.CompanyServiceImpl.deleteCompany.start id:{}", id);
        CompanyEntity company = getCompanyEntityIfExist(id);
        company.setStatus(DELETED);
        companyRepository.save(company);
    }

    private CompanyEntity getCompanyEntityIfExist(Long id){
        return companyRepository.findByIdAndStatusNot(id, DELETED)
                .orElseThrow(() -> new NotFoundException("Company Not Found with id: "+ id));
    }
}
