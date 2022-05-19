package loginTests;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import lib.TestData;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import suits.LoginPageTestsSuit;

@RunWith(JUnitParamsRunner.class)
@Category(LoginPageTestsSuit.class)
public class VerifyIfAllErrorMessagesAppearedTest extends BaseTest {
    /*
    Error messages:
    Case 1 Empty fields->>                     ERRORS: Please enter username. Please enter your password.
    Case 2 Invalid login ->>                   ERROR: No account found with that username.
    Case 3 Valid Login – test, invalid password ->> ERROR: The password you entered was not valid.
     */

    @Test
   public void verifyIfAllErrorMessagesAppearedInCaseEmptyFields(){

        loginPage.openLoginPage();
        loginPage
                .verifyTheLoginPageIsOpened()
                .enterUserName(" ")
                .enterPassword(" ")
                .clickLoginBtn()
                .verifyIfErrorMessagesAppearedInCaseEmptyFields();
    }
    @Test
    public void verifyIfErrorMessageAppearedInCaseNoAccount(){

        loginPage.openLoginPage();
        loginPage
                .verifyTheLoginPageIsOpened()
                .enterUserName(TestData.INVALID_LOGIN)
                .enterPassword(TestData.INVALID_PASSWORD)
                .clickLoginBtn()
                .verifyIfErrorMessageAppearedInCaseNoAccount();
    }

    @Test
    public void verifyIfErrorMessageAppearedInCaseInvalidPassword(){

        loginPage.openLoginPage();
        loginPage
                .verifyTheLoginPageIsOpened()
                .enterUserName(TestData.VALID_LOGIN)
                .enterPassword(TestData.INVALID_PASSWORD)
                .clickLoginBtn()
                .verifyIfErrorMessageAppearedInCaseInvalidPassword();
    }

}
