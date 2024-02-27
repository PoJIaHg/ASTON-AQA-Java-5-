import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class MtsByTests {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Указываем путь к драйверу (подставьте свой путь)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Создаем экземпляр драйвера
        driver = new ChromeDriver();
        // Максимизируем окно браузера
        driver.manage().window().maximize();
        // Открываем сайт mts.by
        driver.get("https://mts.by/");
    }

    @Test
    public void testBlockTitle() {
        // Проверка названия указанного блока
        WebElement blockTitle = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение без комиссии']"));
        assertEquals(blockTitle.getText(), "Онлайн пополнение без комиссии", "Incorrect block title");
    }

    @Test
    public void testPaymentSystemLogos() {
        // Проверка наличия логотипов платёжных систем
        WebElement paymentSystemLogos = driver.findElement(By.className("payment-system-logos"));
        assertTrue(paymentSystemLogos.isDisplayed(), "Payment system logos are not displayed");
    }

    @Test
    public void testServiceDetailsLink() {
        // Проверка работы ссылки «Подробнее о сервисе»
        WebElement detailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        detailsLink.click();
        // Проверяем, что открылась новая вкладка или окно с подробностями
        assertEquals(driver.getWindowHandles().size(), 2, "Details link did not open a new window or tab");
        // Переключаемся на новую вкладку или окно
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        // Проверяем URL или другие характеристики новой вкладки/окна
        assertTrue(driver.getCurrentUrl().contains("details-page"), "Details page not opened");
        // Закрываем новую вкладку или окно и переключаемся обратно
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

    @Test
    public void testFillFieldsAndContinueButton() {
        // Заполнение полей и проверка работы кнопки «Продолжить»
        WebElement phoneNumberInput = driver.findElement(By.id("phone_number"));
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));

        // Ввод номера телефона для теста
        phoneNumberInput.sendKeys("297777777");

        // Проверка, что поле ввода заполнено корректно
        assertEquals(phoneNumberInput.getAttribute("value"), "297777777", "Incorrect phone number entered");

        // Клик по кнопке "Продолжить"
        continueButton.click();

        // Дополнительные проверки после нажатия кнопки "Продолжить"
        // (например, проверка появления дополнительных полей, сообщений об ошибке и т.д.)
    }

    @AfterClass
    public void tearDown() {
        // Закрываем браузер после выполнения всех тестов
        driver.quit();
    }
}
