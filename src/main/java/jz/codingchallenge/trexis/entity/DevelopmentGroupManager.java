package jz.codingchallenge.trexis.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="DEVELOPMENT_GROUP_MANAGER")
@Getter
@Setter
@IdClass(DevelopmentGroupManager.class)
public class DevelopmentGroupManager implements Serializable {

    @OneToOne
    @Id
    private DevelopmentGroup developmentGroup;
    @Id
    private Long managerId;
}
