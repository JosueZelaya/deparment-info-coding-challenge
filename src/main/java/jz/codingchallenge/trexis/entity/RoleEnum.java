package jz.codingchallenge.trexis.entity;

import lombok.Getter;

@Getter
public enum RoleEnum {
    MANAGER (1L,"MANAGER"),
    SENIOR_DEVELOPER (2L,"SENIOR_DEVELOPER"),
    JUNIOR_DEVELOPER (3L,"JUNIOR_DEVELOPER"),
    QA_TESTER (4L,"QA_TESTER");

    private Long id;
    private String title;

    private RoleEnum(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static RoleEnum getRole(final Long id){
        for(RoleEnum role: values()){
            if(role.getId().equals(id)){
                return role;
            }
        }
        return null;
    }


}
