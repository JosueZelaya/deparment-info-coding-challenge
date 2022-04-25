package jz.codingchallenge.trexis.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jz.codingchallenge.trexis.entity.DevelopmentGroup;
import jz.codingchallenge.trexis.entity.DevelopmentGroupManager;
import jz.codingchallenge.trexis.entity.QDevelopmentGroup;
import jz.codingchallenge.trexis.entity.QDevelopmentGroupManager;
import jz.codingchallenge.trexis.repository.DevelopmentGroupManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DevelopmentGroupManagerService {

    private final QDevelopmentGroupManager qDevelopmentGroupManager = QDevelopmentGroupManager.developmentGroupManager;
    private final QDevelopmentGroup qDevelopmentGroup = QDevelopmentGroup.developmentGroup;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DevelopmentGroupManagerRepository developmentGroupManagerRepository;

    private JPAQueryFactory newJPAQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    public List<DevelopmentGroup> findByManager(Long managerId) {
        BooleanExpression matchManagerId = qDevelopmentGroupManager.managerId.eq(managerId);
        BooleanExpression matchDevGroupIds = qDevelopmentGroupManager.developmentGroup.id.eq(qDevelopmentGroup.id);
        List<DevelopmentGroupManager> developmentGroupManagers =  newJPAQueryFactory().selectFrom(qDevelopmentGroupManager)
                .leftJoin(qDevelopmentGroup)
                .on(matchDevGroupIds)
                .where(matchManagerId).fetch();
        return developmentGroupManagers.stream().map(x -> x.getDevelopmentGroup()).collect(Collectors.toList());
    }

}
