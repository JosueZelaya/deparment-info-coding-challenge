package jz.codingchallenge.trexis.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEES")
@Getter
@Setter
public class Employee {

    @Id
    private Long id;
    private String firstName;

    //@JoinColumn(name = "roles", referencedColumnName = "id")
    @ManyToOne
    private Role role;

    public RoleEnum getRole(){
        return RoleEnum.getRole(role.getId());
    }


    /*ID bigint not null,
    FIRST_NAME varchar(30),
    LAST_NAME varchar(30),
    BIRTH_DATE date,
    GENDER ENUM('M','F'),
    DEPARTMENT_ID bigint,
    MANAGER_ID bigint,
    ROLE_ID bigint,
    DEVELOPMENT_GROUP_ID bigint,*/

}