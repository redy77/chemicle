package com.chemcool.school.auth.test;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.domain.RegisterUserEvent;

public class RegisterUserEventPrototype {
    public static RegisterUserEvent aRegisterUserEvent(){
        RegisterUserEvent rUserEvent = new RegisterUserEvent();
        rUserEvent.setEventId("test_eventId");
        rUserEvent.setEventVersion("test_eventVersion");
        rUserEvent.setAuthorId("test_authorId");
        rUserEvent.setOccurringContext("test_occurringContext");
        return rUserEvent;
    }
}
