package org.example.utilities;

import org.testng.annotations.DataProvider;


public class InvalidDataForLogIn {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidData() {
        return new Object[][]{
                {"email", "pwd234"},
                {"email1", "pwd4"},
                {"test", "newpwd"}
        };
    }


}
