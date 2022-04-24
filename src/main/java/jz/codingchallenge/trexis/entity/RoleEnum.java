package jz.codingchallenge.trexis.entity;

public enum RoleEnum {
    MANAGER ("MANAGER"),
    SENIOR_DEVELOPER ("SENIOR_DEVELOPER"),
    JUNIOR_DEVELOPER ("JUNIOR_DEVELOPER"),
    QA_TESTER ("QA_TESTER");

    private String title;

    RoleEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
