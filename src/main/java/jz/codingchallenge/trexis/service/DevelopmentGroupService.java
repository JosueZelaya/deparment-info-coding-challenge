package jz.codingchallenge.trexis.service;

import jz.codingchallenge.trexis.repository.DevelopmentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevelopmentGroupService {

    @Autowired
    DevelopmentGroupRepository developmentGroupRepository;
}
