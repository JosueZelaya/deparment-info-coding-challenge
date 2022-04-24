package jz.codingchallenge.trexis.service;

import com.querydsl.jpa.impl.JPAQuery;
import jz.codingchallenge.trexis.entity.Department;
import jz.codingchallenge.trexis.entity.QDepartment;
import jz.codingchallenge.trexis.entity.QEmployee;
import jz.codingchallenge.trexis.entity.QRole;
import jz.codingchallenge.trexis.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final QDepartment qDepartment = QDepartment.department;
    private final QEmployee qEmployee = QEmployee.employee;
    private final QRole qRole = QRole.role;

    @Autowired
    private EntityManager entityManager;

    private JPAQuery newJpaQuery() {
        return new JPAQuery(entityManager);
    }

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }



}
