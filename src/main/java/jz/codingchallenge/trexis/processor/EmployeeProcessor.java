package jz.codingchallenge.trexis.processor;

import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class EmployeeProcessor {

    @Autowired
    private EmployeeService employeeService;

    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    public Iterable<Employee> findAll(@PathVariable("departmentId") Long departmentId){
        return employeeService.findAll(departmentId);
    }

}
