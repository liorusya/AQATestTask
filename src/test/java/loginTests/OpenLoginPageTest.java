package loginTests;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import lib.TestData;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import suits.LoginPageTestsSuit;

@RunWith(JUnitParamsRunner.class)
@Category(LoginPageTestsSuit.class)

public class OpenLoginPageTest extends BaseTest {

    @Test
    public void openTheLoginPage(){
        loginPage.openLoginPage();
        loginPage.verifyTheLoginPageIsOpened();
    }


}
