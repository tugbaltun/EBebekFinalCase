package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements Browser{
    public static ChromeOptions options = new ChromeOptions();
    @Override
    public WebDriver createInstance() {
        WebDriverManager.chromedriver().setup();
        chromeOptions();
        return new ChromeDriver(options);
    }

    public static void chromeOptions(){
        options.addArguments("user-data-dir=C:/Users/Tugba/AppData/Local/Google/Chrome/User Data/Default");
        options.addArguments("--start-maximized");
    }
}
