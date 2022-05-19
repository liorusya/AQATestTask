package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    protected LoginPage loginPage;

    @Before
    public void setUp() {
        logger.info("---");
        logger.info("-------  " + testName.getMethodName() + "  was started --------\n");
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        loginPage = new LoginPage(webDriver);
    }


    @Rule
    public TestName testName = new TestName();

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }

    @After
    public void tearDown() {
//        webDriver.close();
//        logger.info("Browser was closed");
        logger.info("-------  " + testName.getMethodName() + "  was finished --------\n");

    }
    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }
        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }
        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }
        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
                logger.info("Browser was closed");
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };
}

