package jz.codingchallenge.trexis.controller;

import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.processor.EmployeeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("departments/{departmentId}/employees")
public class EmployeeController {

    @Autowired
    private EmployeeProcessor employeeProcessor;

    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAll(@PathVariable("departmentId") Long departmentId){
        return new ResponseEntity<>(employeeProcessor.findAll(departmentId), HttpStatus.OK);
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable("departmentId") Long departmentId, @PathVariable("employeeId") Long employeeId){
        Optional<Employee> employee = employeeProcessor.findById(departmentId);
        if(employee.isPresent()){
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cost")
    public ResponseEntity<BigDecimal> getCost(@PathVariable Long departmentId) {
        return new ResponseEntity<>(employeeProcessor.getCostByDepartment(departmentId), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}/cost")
    public ResponseEntity<BigDecimal> getCost(@PathVariable("departmentId") Long departmentId,
                                              @PathVariable("employeeId") Long employeeId) {
        return new ResponseEntity<>(employeeProcessor.getCostByEmployee(employeeId), HttpStatus.OK);
    }

}
