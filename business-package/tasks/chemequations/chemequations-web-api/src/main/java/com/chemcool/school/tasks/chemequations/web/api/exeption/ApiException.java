package com.chemcool.school.tasks.chemequations.web.api.exeption;

public class ApiException {

    private String massage;

    public ApiException(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
