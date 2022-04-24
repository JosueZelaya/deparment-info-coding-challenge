package jz.codingchallenge.trexis.processor;

import jz.codingchallenge.trexis.entity.Department;
import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.service.DepartmentService;
import jz.codingchallenge.trexis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class DepartmentProcessor {

    @Autowired
    private DepartmentService departmentService;

    public List<Department> findAll() {
        return departmentService.findAll();
    }

    public Optional<Department> findById(Long id) {
        return departmentService.findById(id);
    }

}
