package jz.codingchallenge.trexis.service;

import jz.codingchallenge.trexis.entity.Department;
import jz.codingchallenge.trexis.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAllDeparments() {
        return departmentRepository.findAll();
    }

}
