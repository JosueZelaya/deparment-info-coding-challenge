package jz.codingchallenge.trexis.controller;

import jz.codingchallenge.trexis.dto.DevelopmentGroupDTO;
import jz.codingchallenge.trexis.entity.DevelopmentGroup;
import jz.codingchallenge.trexis.processor.DevelopmentGroupManagerProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments/{depId}/employees/{empId}/devGroups")
public class DevelopmentGroupController {

    @Autowired
    private DevelopmentGroupManagerProcessor developmentGroupManagerProcessor;

    @GetMapping
    public ResponseEntity<List<DevelopmentGroupDTO>> findByManager(@PathVariable("empId") Long empId) {
        return new ResponseEntity<>(developmentGroupManagerProcessor.findByManager(empId), HttpStatus.OK);
    }

}
