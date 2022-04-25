package jz.codingchallenge.trexis.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEVELOPMENT_GROUPS")
@Getter
@Setter
public class DevelopmentGroup {
    @Id
    private Long id;
    private String name;
}
