package jz.codingchallenge.trexis.controller;

import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.processor.EmployeeProcessor;
import jz.codingchallenge.trexis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("departments/{departmentId}/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeProcessor employeeProcessor;

    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAll(@PathVariable("departmentId") Long departmentId){
        return new ResponseEntity<>(employeeProcessor.findAll(departmentId), HttpStatus.OK);
    }

}
