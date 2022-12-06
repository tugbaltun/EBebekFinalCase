package locatorContainers;

import org.openqa.selenium.By;

public class SearchBoxContainer {

    public static By searchBoxLocator = By.xpath("//input[@id='txtSearchBox']");
    public static By searchBoxResults = By.xpath("//h3[@class=\"name\"]");

}
