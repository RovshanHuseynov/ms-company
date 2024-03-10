package com.example.ms.company.dao.repository;

import com.example.ms.company.dao.entity.CompanyEntity;
import com.example.ms.company.model.enums.CompanyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByIdAndStatusNot(Long id, CompanyStatus status);
}
