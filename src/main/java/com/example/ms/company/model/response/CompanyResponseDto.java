package com.example.ms.company.model.response;

import com.example.ms.company.model.enums.CompanyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponseDto {
    private Long id;
    private String name;
    private CompanyStatus status;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;
}
