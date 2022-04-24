package jz.codingchallenge.trexis.controller;

import jz.codingchallenge.trexis.entity.Department;
import jz.codingchallenge.trexis.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        return new ResponseEntity<>(departmentService.findAllDeparments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findBy(@PathVariable Long id){
        Optional<Department> department = departmentService.findById(id);
        if(department.isPresent()) {
            return new ResponseEntity<>(department.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
