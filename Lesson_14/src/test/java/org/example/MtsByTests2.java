import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MtsByTests2 {

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



    @Test
    //проверки заполнения полей и данных во всплывающем окне оплаты услуг связи
    public void PaymentChecks() {
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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")));

        assertTrue(popupWindow.isEnabled());

        WebElement iframeElement = driver.findElement(By.className("bepaid-iframe"));


        driver.switchTo().frame(iframeElement);


        WebElement elementInsideFrame = driver.findElement(By.xpath("/html/body/app-root/div/div"));
        assertTrue(elementInsideFrame.getText().contains("66"));
        assertTrue(elementInsideFrame.getText().contains("297777777"));
        assertTrue(elementInsideFrame.getText().contains("Номер карты"));
        assertTrue(elementInsideFrame.getText().contains("Срок действия"));
        assertTrue(elementInsideFrame.getText().contains("CVC"));
        assertTrue(elementInsideFrame.getText().contains("Имя держателя"));

        WebElement paymentLogos = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div"));
        assertTrue(paymentLogos.isDisplayed());

        driver.switchTo().defaultContent();
        }

    //тест на выпадающий список НЕ ДОДЕЛАН (голова кругом, туплю и в итоге не успел :( )
    @Test
    public void testSelectTitles() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Принять']")));
        acceptButton.click();

        WebElement paymentDropdown = driver.findElement(By.className("select__list"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentDropdown);

        WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul"));
        iframeElement.click();
        driver.switchTo().frame(iframeElement);

        Actions builder = new Actions(driver);
        builder.moveToElement(paymentDropdown).click().build().perform();



    }
    }