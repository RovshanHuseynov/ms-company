package com.example.ms.company.controller;

import com.example.ms.company.model.request.CreateCompanyRequestDto;
import com.example.ms.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createCompany(@RequestBody CreateCompanyRequestDto company){
        log.info("ActionLog.createCompany.start request:{}", company);
        companyService.createCompany(company);
    }
}
