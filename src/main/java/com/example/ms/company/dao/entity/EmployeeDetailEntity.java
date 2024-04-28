package com.example.ms.company.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;
@Getter
@Setter
//@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_details")
@Builder
public class EmployeeDetailEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /*@Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "insert_date")
    private LocalDateTime insertDate;*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDetailEntity that = (EmployeeDetailEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
