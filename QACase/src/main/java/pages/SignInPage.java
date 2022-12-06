package pages;

import org.openqa.selenium.WebDriver;

import static locatorContainers.SignInPageContainer.signInButton;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnSignInPage(){
        return isDisplayed(signInButton);
    }
}
