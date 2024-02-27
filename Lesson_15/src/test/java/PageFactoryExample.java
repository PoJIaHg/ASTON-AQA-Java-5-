import org.openqa.selenium.WebDriver;
import java.lang.reflect.Constructor;


public class PageFactoryExample {
    public static <T> T createPage(Class<T> pageClass, WebDriver driver) {
        try {
            Constructor<T> constructor = pageClass.getConstructor(WebDriver.class);
            return constructor.newInstance(driver);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create page instance", e);
        }
    }
}
