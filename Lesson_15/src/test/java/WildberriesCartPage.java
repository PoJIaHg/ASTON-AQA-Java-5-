import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
public class WildberriesCartPage {
    private WebDriver driver;

    public WildberriesCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProductNames() {

        List<String> productNames = driver.findElements(By.xpath("//*[@id='app']//article[contains(., 'Завтра')]/div/div[3]/p[3]/a/span[2]")).stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());

        return productNames;
    }

    public List<String> getProductQuantities() {

        List<String> productQuantities = driver.findElements(By.xpath("//*[@id=\"app\"]/div[4]/div/div[1]/form/div[2]/div/div/div/div[2]/div/span[1]")).stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());

        return productQuantities;
    }

    public List<Double> getProductPrices() {
        // Логика получения цен товаров в корзине
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        List<Double> productPrices = driver.findElements(By.xpath("//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div[3]/div[3]")).stream()
                .map(webElement -> {
                    try {
                        return decimalFormat.parse(webElement.getText().replace("₽", "").replaceAll("\\s+", "")).doubleValue();
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return 0.0;
                    }
                })
                .collect(Collectors.toList());

        return productPrices;
    }

}
