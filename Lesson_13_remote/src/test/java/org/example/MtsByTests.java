import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MtsByTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by/");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
            }

    // 1
    @Test
    public void testBlockTitle() {
        // Принимаем Cookies
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Принять']")));
        acceptButton.click();

        WebElement blockTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")));

        assertTrue(blockTitle.isDisplayed());
    }
    // 2
    @Test
    public void testPaymentSystemLogos() {

        WebElement paymentSystemLogos = driver.findElement(By.className("pay__partners"));
        assertTrue(paymentSystemLogos.isDisplayed());

    }

    // 3
    @Test
    public void testServiceDetailsLink() {
        // Принимаем Cookies
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Принять']")));
        acceptButton.click();
        WebElement moreAbout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a")));
        moreAbout.click();
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        assertEquals(driver.getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }

    // 4
    @Test
    public void testContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Принять']")));
        acceptButton.click();


        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneInput.sendKeys("297777777");

        WebElement amountInput = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        amountInput.sendKeys("66");

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        emailInput.sendKeys("PoJIaHg@yandex.ru");


        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement popupWindow = driver.findElement(By.id("bxdynamic_cookies-agreement-pt1_end"));


        assertTrue(popupWindow.isEnabled(), "Popup window is not enabled");
    }
}

