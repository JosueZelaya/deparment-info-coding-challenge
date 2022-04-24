package jz.codingchallenge.trexis.repository;

import jz.codingchallenge.trexis.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RoleRepository extends JpaRepository<Role, Long>, QuerydslPredicateExecutor {


}
