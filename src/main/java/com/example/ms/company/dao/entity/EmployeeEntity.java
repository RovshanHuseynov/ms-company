package com.example.ms.company.dao.entity;

<<<<<<< HEAD
import com.example.ms.company.model.enums.EmployeeStatus;
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
>>>>>>> origin/master
import lombok.*;

import java.util.Objects;

<<<<<<< HEAD
import static jakarta.persistence.EnumType.STRING;
=======
>>>>>>> origin/master
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
//@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
@Builder
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "full_name")
    private String fullName;

    @Enumerated(STRING)
    private EmployeeStatus status;

=======
    private String fullName;

>>>>>>> origin/master
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
