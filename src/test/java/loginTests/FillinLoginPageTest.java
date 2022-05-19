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

public class FillinLoginPageTest extends BaseTest {

    @Test
    public void fillinTheLoginPageTest(){
        loginPage.openLoginPage();
        loginPage
                .verifyTheLoginPageIsOpened()
                .enterUserName(TestData.VALID_LOGIN)
                .enterPassword(TestData.INVALID_PASSWORD)
                .clickLoginBtn()
                .verifyTheUserNameEntered(TestData.VALID_LOGIN);
    }

}
