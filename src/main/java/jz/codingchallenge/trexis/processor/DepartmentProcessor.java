package jz.codingchallenge.trexis.processor;

import jz.codingchallenge.trexis.entity.Department;
import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.service.DepartmentService;
import jz.codingchallenge.trexis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentProcessor {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    public List<Department> findAll() {
        return departmentService.findAll();
    }

    public Optional<Department> findById(Long id) {
        return departmentService.findById(id);
    }



}
