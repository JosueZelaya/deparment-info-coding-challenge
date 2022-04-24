package jz.codingchallenge.trexis.controller;

import jz.codingchallenge.trexis.entity.Role;
import jz.codingchallenge.trexis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public Iterable<Role> findAll() {
        return roleService.findAll();
    }
}
