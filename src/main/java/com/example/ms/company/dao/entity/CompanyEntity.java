package com.example.ms.company.dao.entity;

import com.example.ms.company.model.enums.CompanyStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
//@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
@Builder
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @Enumerated(STRING)
    private CompanyStatus status;

    @OneToOne(
            mappedBy = "company",
            cascade = ALL,
            fetch = LAZY
    )
    @ToString.Exclude
    private CompanyDetailEntity detail;

    @OneToMany(
            mappedBy = "company",
            cascade = ALL
    )
    @ToString.Exclude
    private List<EmployeeEntity> employees;

    @ManyToMany(cascade = ALL)
    @JoinColumn
    @ToString.Exclude
    private List<FounderEntity> founders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
