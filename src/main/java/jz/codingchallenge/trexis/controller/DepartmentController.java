package jz.codingchallenge.trexis.controller;

import jz.codingchallenge.trexis.entity.Department;
import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.processor.DepartmentProcessor;
import jz.codingchallenge.trexis.processor.EmployeeProcessor;
import jz.codingchallenge.trexis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentProcessor departmentProcessor;

    @Autowired
    private EmployeeProcessor employeeProcessor;

    @GetMapping
    public ResponseEntity<Iterable<Department>> findAll(){
        return new ResponseEntity<>(departmentProcessor.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findBy(@PathVariable Long id){
        Optional<Department> department = departmentProcessor.findById(id);
        if(department.isPresent()) {
            return new ResponseEntity<>(department.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> findAllEmployees(){
        return new ResponseEntity<>(employeeProcessor.findAll(), HttpStatus.OK);
    }

}
