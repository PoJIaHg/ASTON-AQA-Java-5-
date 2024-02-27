import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class WildberriesTest {
    @Test
    public void testWildberriesShopping() {
        WebDriver driver = WebDriverSingleton.getInstance();
        WildberriesHomePage homePage = PageFactoryExample.createPage(WildberriesHomePage.class, driver);
        WildberriesCartPage cartPage = PageFactoryExample.createPage(WildberriesCartPage.class, driver);

        homePage.open();
        homePage.addToCart(1);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.addToCart(2);


        driver.get("https://www.wildberries.ru/lk/basket");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<String> productNames = cartPage.getProductNames();
        List<String> productQuantities = cartPage.getProductQuantities();
        List<Double> productPrices = cartPage.getProductPrices();

        assertEquals(productNames.size(), 2, "Unexpected number of products in the cart");
        assertTrue(productQuantities.contains("Товар"), "Product 1 is missing in the cart");
        assertTrue(productPrices.contains("₽"), "Product 2 is missing in the cart");



    }
}


