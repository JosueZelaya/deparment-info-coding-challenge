package jz.codingchallenge.trexis.service;

import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
