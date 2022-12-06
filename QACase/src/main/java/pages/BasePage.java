package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver ;
    WebDriverWait wait ;

    public BasePage(WebDriver driver){
        this.driver = driver ;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }

    public WebElement find(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElements(locator);
    }

    public void click(By locator){

        find(locator).click();
    }

    public void type(By locator , String text){

        find(locator).sendKeys(text);
    }

    public boolean isDisplayed(By locator){

        return find(locator).isDisplayed();
    }
}
