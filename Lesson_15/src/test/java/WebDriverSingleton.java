import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverSingleton {
    private static WebDriver instance;

    private WebDriverSingleton() {

    }

    public static WebDriver getInstance() {
        if (instance == null) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            instance = new ChromeDriver();
        }
        return instance;
    }
}
