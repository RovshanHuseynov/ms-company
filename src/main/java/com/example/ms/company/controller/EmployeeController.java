package com.example.ms.company.controller;

import com.example.ms.company.service.abstraction.EmplyeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmplyeeService emplyeeService;
}
