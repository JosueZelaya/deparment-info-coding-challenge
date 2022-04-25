package jz.codingchallenge.trexis.processor;

import com.querydsl.jpa.impl.JPAQuery;
import jz.codingchallenge.trexis.entity.DevelopmentGroup;
import jz.codingchallenge.trexis.entity.Employee;
import jz.codingchallenge.trexis.entity.RoleEnum;
import jz.codingchallenge.trexis.service.DevelopmentGroupManagerService;
import jz.codingchallenge.trexis.service.DevelopmentGroupService;
import jz.codingchallenge.trexis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
public class EmployeeProcessor {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DevelopmentGroupManagerService developmentGroupManagerService;

    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeService.findById(id);
    }

    public Iterable<Employee> findAll(@PathVariable("departmentId") Long departmentId){
        return employeeService.findByDepartment(departmentId);
    }

    public BigDecimal getCostByDepartment(Long departmentId)  {
        Iterable<Employee> employees = employeeService.findByDepartment(departmentId);
        return StreamSupport.stream(employees.spliterator(), false) // convert iterable to stream
                .map(x -> x.getRole().getSalary())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getCostByEmployee(Long employeeId) {
        BigDecimal cost = BigDecimal.ZERO;
        Optional<Employee> employee = employeeService.findById(employeeId);
        if(employee.isPresent()){
            cost = cost.add(employee.get().getRole().getSalary());
            Iterable<Employee> underneathEmployees = employeeService.findByManager(employee.get().getId());
            if(!underneathEmployees.iterator().hasNext()) {
                return cost;
            }
            for(Employee underneathEmployee : underneathEmployees) {
                cost = cost.add(getCostByEmployee(underneathEmployee.getId()));
            }
        }
        return cost;
    }

    public String getResponsibilityStatus(Long employeeId) {
        List<DevelopmentGroup> developmentGroups = developmentGroupManagerService.findByManager(employeeId);
        if(developmentGroups.size() > 0) return "enough responsibility";
        Iterable<Employee> underneathManagers = employeeService.findAll(null, null, RoleEnum.MANAGER.getId(), employeeId);
        Long numOfUnderneathManagers = StreamSupport.stream(underneathManagers.spliterator(), false).count();
        if(developmentGroups.size() > 0 && numOfUnderneathManagers > 0) return "enough responsibility";
        if(numOfUnderneathManagers > 1) return "enough responsibility";
        return "Too little responsibility";
    }

}
