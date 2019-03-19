package com.itc.qa.automat;

import com.itc.qa.automat.usecases.UseCases;
import org.testng.annotations.Test;

public class TypicalUseCases {

    private UseCases useCases = new UseCases();

    @Test
    public void solveRegistrationSuccess(){

        useCases.solveRegistrationSuccess();
    }
}
