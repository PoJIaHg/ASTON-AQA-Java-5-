import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WildberriesHomePage {
    private WebDriver driver;

    public WildberriesHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.wildberries.ru/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void addToCart(int productIndex) {
        String addToCartXPath = String.format("//*[@id='app']//article[contains(., 'Послезавтра')]/div/div[3]/p[3]/a/span[2]", productIndex);
        driver.findElement(By.xpath(addToCartXPath)).click();
    }


}


