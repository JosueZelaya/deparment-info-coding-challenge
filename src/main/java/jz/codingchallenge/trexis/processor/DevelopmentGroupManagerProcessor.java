package jz.codingchallenge.trexis.processor;

import jz.codingchallenge.trexis.dto.DevelopmentGroupDTO;
import jz.codingchallenge.trexis.entity.DevelopmentGroup;
import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.entity.RoleEnum;
import jz.codingchallenge.trexis.service.DevelopmentGroupManagerService;
import jz.codingchallenge.trexis.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DevelopmentGroupManagerProcessor {

    @Autowired
    private DevelopmentGroupManagerService developmentGroupManagerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper mapper;

    public List<DevelopmentGroupDTO> findByManager(Long managerId) {
        List<DevelopmentGroupDTO> developmentGroups = developmentGroupManagerService.findByManager(managerId)
                .stream().map(devGroup -> {
                    DevelopmentGroupDTO devGrDTO = mapper.map(devGroup, DevelopmentGroupDTO.class);
                    Iterable<Employee> employees = employeeService.findByDevelopmentGroup(devGroup.getId());
                    boolean hasSeniorDev = false;
                    boolean hasQA = false;
                    Iterator<Employee> itr = employees.iterator();
                    while(itr.hasNext()) {
                        Employee employee = itr.next();
                        if(employee.getRole().getTitle().equals(RoleEnum.SENIOR_DEVELOPER)) hasSeniorDev = true;
                        if(employee.getRole().getTitle().equals(RoleEnum.QA_TESTER)) hasQA = true;
                    }
                    devGrDTO.setStatus(hasSeniorDev && hasQA? "Properly staffed": "Understaffed");
                    return devGrDTO;
                }).collect(Collectors.toList());
        return developmentGroups;
    }


}
