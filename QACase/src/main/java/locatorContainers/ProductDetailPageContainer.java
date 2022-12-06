package locatorContainers;

import org.openqa.selenium.By;

public class ProductDetailPageContainer {
    public static By productDetailsTabButton = By.id("btnProductDetailsTab");
    public static By productAddedToCartInfo = By.xpath("//p[text()=\" Ürün Sepetinizde \"]");
    public static By addToCartButton = By.id("addToCartBtn");
    public static By goToCartButton = By.id("btnShowCart");
    //public static By productName = By.xpath("//b[contains(@id, 'txtProductTitle') and text() = 'Sütlü Pirinçli K
    public static By productTitle = By.xpath("//h1[@id=\"txtBrandName\"]/b[@id=\"txtProductTitle\"]");
}
