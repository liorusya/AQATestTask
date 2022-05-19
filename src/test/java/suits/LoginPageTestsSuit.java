package suits;

import loginTests.FillinLoginPageTest;
import loginTests.OpenLoginPageTest;
import loginTests.VerifyIfAllWebElementsAreDisplayedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OpenLoginPageTest.class,
        FillinLoginPageTest.class,
        VerifyIfAllWebElementsAreDisplayedTest.class
})
public class LoginPageTestsSuit {

}
