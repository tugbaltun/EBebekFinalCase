package pages;

import org.openqa.selenium.WebDriver;

import static locatorContainers.ProductDetailPageContainer.*;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(productDetailsTabButton);
    }

    public void addToCart() {
        click(addToCartButton);
    }

    public boolean isOnProductAddedToCart() {
        return isDisplayed(productAddedToCartInfo);
    }

    public void goToCartPage() {
        click(goToCartButton);
    }
}
