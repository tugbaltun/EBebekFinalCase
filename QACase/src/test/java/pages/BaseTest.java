package pages;

import browsers.BrowserFactory;
import exceptions.BrowserException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import testLogger.TestResultLogger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {

    WebDriver driver;

    @BeforeAll
    void setUp() throws BrowserException{
        driver = BrowserFactory.getBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.e-bebek.com/");
    }

    @AfterAll
    void tearDown(){
        driver.quit();
    }
}
