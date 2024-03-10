package com.example.ms.company.controller;

import com.example.ms.company.model.request.CreateCompanyRequestDto;
import com.example.ms.company.model.response.CompanyResponseDto;
import com.example.ms.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createCompany(@RequestBody CreateCompanyRequestDto company){
        companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public CompanyResponseDto getCompany(@PathVariable Long id){
        return companyService.getCompany(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateCompany(@PathVariable Long id, @RequestParam String name){
        companyService.updateCompany(id, name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }
}
