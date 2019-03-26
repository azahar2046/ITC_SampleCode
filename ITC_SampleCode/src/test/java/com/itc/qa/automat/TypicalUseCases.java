package com.itc.qa.automat;

import com.itc.qa.automat.common.RetryAnalyzer;
import com.itc.qa.automat.usecases.UseCases;
import org.testng.annotations.Test;

public class TypicalUseCases {

    private UseCases useCases = new UseCases();


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void solveRegistrationSuccess() {

        useCases.solveRegistrationSuccess();
    }


}
