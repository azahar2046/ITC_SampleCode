package com.itc.qa.automat.usecases;

import com.itc.qa.automat.values.RegistrationValues;

public class UseCases {

    public void solveRegistrationSuccess(){

        Registration registration = new Registration();

        RegistrationValues registrationValues = new RegistrationValues();

        registration.success(registrationValues);

    }

}
