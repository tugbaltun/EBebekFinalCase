package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    SearchBox searchBox;

    public HomePage(WebDriver webDriver){
        super(webDriver);
        searchBox = new SearchBox(webDriver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }
}
