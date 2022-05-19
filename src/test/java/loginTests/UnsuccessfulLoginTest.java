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
public class UnsuccessfulLoginTest extends BaseTest {


    @Test
    //Notice: for the current task was not specified -> Expected result in case unsuccessful login...
    // Run with Maven to find the Attached file in the allure report
    public void invalidLoginTest(){
        loginPage.openLoginPage();
        loginPage
                .verifyTheLoginPageIsOpened()
                .enterUserName(TestData.VALID_LOGIN)
                .enterPassword(TestData.INVALID_PASSWORD)
                .clickLoginBtn()
                .verifyIfUserNameFieldIsNOTDisplayed();
    }
}
