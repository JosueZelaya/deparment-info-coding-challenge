package jz.codingchallenge.trexis.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
@Getter
@Setter
public class Role {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum title;

}