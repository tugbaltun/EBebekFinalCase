package locatorContainers;

import org.openqa.selenium.By;

public class ProductDetailPageContainer {
    public static By productDetailsTabButton = By.id("btnProductDetailsTab");
    public static By productAddedToCartInfo = By.xpath("//div[@class=\"d-flex align-items-center\"]/p[@class=\"info-text\"]");
    public static By addToCartButton = By.id("addToCartBtn");
    public static By goToCartButton = By.id("btnShowCart");
    public static By productTitle = By.xpath("//h1[@id=\"txtBrandName\"]/b[@id=\"txtProductTitle\"]");
}
