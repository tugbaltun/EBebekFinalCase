package pages;

import browsers.BrowserFactory;
import exceptions.BrowserException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    }
}
