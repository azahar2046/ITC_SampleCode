package com.itc.qa.automat.usecases;

import com.itc.qa.automat.values.EducationDetailsValues;
import com.itc.qa.automat.values.PersonalDetailsValues;
import com.itc.qa.automat.values.PreferencesValues;

public class UseCases {

    public void solveRegistrationSuccess(){

        Registration registration = new Registration();

        PersonalDetailsValues pd = new PersonalDetailsValues();

        EducationDetailsValues ed = new EducationDetailsValues();

        PreferencesValues pv = new PreferencesValues();

        registration.success(pd,ed,pv);

    }

}
