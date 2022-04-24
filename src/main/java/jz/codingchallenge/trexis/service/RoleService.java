package jz.codingchallenge.trexis.service;

import jz.codingchallenge.trexis.entity.Role;
import jz.codingchallenge.trexis.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }


}
