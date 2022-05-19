package loginTests;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import suits.LoginPageTestsSuit;

@RunWith(JUnitParamsRunner.class)
@Category(LoginPageTestsSuit.class)
public class VerifyIfAllWebElementsAreDisplayedTest extends BaseTest {
    @Test
    public void verifyIfAllWebElementsAreDisplayedTest () {
        loginPage.openLoginPage();
        loginPage
                .verifyTheLoginPageIsOpened()
                .verifyIfUserNameFieldIsDisplayed()
                .verifyIfPasswordFieldIsDisplayed()
                .verifyIfLoginBtnDisplayed();
    }


}
