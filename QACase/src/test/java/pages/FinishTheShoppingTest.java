package pages;

import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class FinishTheShoppingTest extends BaseTest{
    HomePage homePage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    SignInPage signInPage;

    @Test
    @Order(1)
    public void searchProduct(){
        homePage = new HomePage(driver);
        productDetailPage = new ProductDetailPage(driver);
        Assertions.assertTrue(
                homePage
                .searchBox()
                .searchResult("kaşık maması") , "Didn't click on the right product !"
        );
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");
    }

    @Test
    @Order(2)
    public void addToCart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(productDetailPage.isOnProductAddedToCart(),
                "Not on product added to cart information page!");
    }

    @Test
    @Order(3)
    public void goToCart(){
        cartPage = new CartPage(driver);
        productDetailPage.goToCartPage();
        Assertions.assertTrue(cartPage.checkIfProductAdded() ,
                "Product was not added to cart!");
    }

    @Test
    @Order(4)
    public void finishTheShopping(){
        cartPage = new CartPage(driver);
        signInPage = new SignInPage(driver);
        cartPage.clickFinishShoppingButton();
        Assertions.assertTrue(signInPage.isOnSignInPage() ,
                "Login page not opened!");
    }

}
