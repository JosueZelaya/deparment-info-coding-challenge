package jz.codingchallenge.trexis.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.entity.QEmployee;
import jz.codingchallenge.trexis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final QEmployee qEmployee = QEmployee.employee;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Iterable<Employee> findAllByDepartment(Long departmentId) {
        BooleanExpression inDepartment = qEmployee.department.id.eq(departmentId);
        return employeeRepository.findAll(inDepartment);
    }

}
