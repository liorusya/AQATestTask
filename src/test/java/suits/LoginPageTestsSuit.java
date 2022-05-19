package suits;

import loginTests.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OpenLoginPageTest.class,
        FillinLoginPageTest.class,
        VerifyIfAllWebElementsAreDisplayedTest.class,
        VerifyIfAllErrorMessagesAppearedTest.class,
        UnsuccessfulLoginTest.class

})
public class LoginPageTestsSuit {

}
