package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static locatorContainers.ProductDetailPageContainer.productTitle;
import static locatorContainers.SearchBoxContainer.*;

public class SearchBox extends BasePage{
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        isDisplayed(searchBoxLocator);
        click(searchBoxLocator);
        type(searchBoxLocator, text);
        searchBox.sendKeys(Keys.ENTER);
    }

    public boolean searchResult(String text) {
        isDisplayed(searchBoxLocator);
        click(searchBoxLocator);
        type(searchBoxLocator, text);
        List<WebElement> results = findAll(searchBoxResults);
        String resultName = results.get(results.size()-1).getText();
        results.get(results.size()-1).click();
        String titleName = find(productTitle).getText();
        return titleName.equals(resultName);
    }

}
