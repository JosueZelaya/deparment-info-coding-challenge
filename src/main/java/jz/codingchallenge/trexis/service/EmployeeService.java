package jz.codingchallenge.trexis.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.sql.JPASQLQuery;
import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.entity.QEmployee;
import jz.codingchallenge.trexis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final QEmployee qEmployee = QEmployee.employee;

    @Autowired
    private EntityManager entityManager;

    private JPAQuery newJpaQuery() {return new JPAQuery(entityManager);}

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> findById(Long id) { return employeeRepository.findById(id); }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Iterable<Employee> findByDepartment(Long departmentId) {
        BooleanExpression inDepartment = qEmployee.department.id.eq(departmentId);
        return employeeRepository.findAll(inDepartment);
    }

    public Iterable<Employee> findAll(Long departmentId, Long employeeId, Long roleId, Long managerId) {
        BooleanBuilder booleanFilters = new BooleanBuilder();
        if (Optional.ofNullable(employeeId).isPresent()) {
            booleanFilters.and(qEmployee.id.eq(employeeId));
        }
        if (Optional.ofNullable(departmentId).isPresent()) {
            booleanFilters.and(qEmployee.department.id.eq(departmentId));
        }
        if (Optional.ofNullable(roleId).isPresent()) {
            booleanFilters.and(qEmployee.role.id.eq(roleId));
        }
        if (Optional.ofNullable(managerId).isPresent()){
            booleanFilters.and(qEmployee.manager.id.eq(managerId));
        }
        return employeeRepository.findAll(booleanFilters);
    }

    public Iterable<Employee> findByManager(Long managerId) {
        BooleanExpression underManager = qEmployee.manager.id.eq(managerId);
        return employeeRepository.findAll(underManager);
    }




}
