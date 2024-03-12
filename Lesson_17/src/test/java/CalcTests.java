import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTests {

    AndroidDriver<AndroidElement> driver = null;

    @BeforeEach
    public void setUp() {
        initialize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
    public void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Poco X3 Pro");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);


        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }



@Test
public void checkSum() {
    driver.findElementById("com.google.android.calculator:id/digit_6").click();
    driver.findElementById("com.google.android.calculator:id/op_add").click();
    driver.findElementById("com.google.android.calculator:id/digit_9").click();
    driver.findElementById("com.google.android.calculator:id/eq").click();
    assertEquals("15", driver.findElementByAndroidUIAutomator("new UiSelector().packageNameMatches(\"com.google.android.calculator\").resourceId(\"com.google.android.calculator:id/result_final\")").getText());
}

    @Test
    public void checkResidual() {
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_sub").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("0", driver.findElementByAndroidUIAutomator("new UiSelector().packageNameMatches(\"com.google.android.calculator\").resourceId(\"com.google.android.calculator:id/result_final\")").getText());
    }

@Test
public void checkMultiply() {
    driver.findElementById("com.google.android.calculator:id/digit_6").click();
    driver.findElementById("com.google.android.calculator:id/op_mul").click();
    driver.findElementById("com.google.android.calculator:id/digit_6").click();
    driver.findElementById("com.google.android.calculator:id/eq").click();
    assertEquals("36", driver.findElementByAndroidUIAutomator("new UiSelector().packageNameMatches(\"com.google.android.calculator\").resourceId(\"com.google.android.calculator:id/result_final\")").getText());
}
    @Test
    public void checkDivide() {
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("1", driver.findElementByAndroidUIAutomator("new UiSelector().packageNameMatches(\"com.google.android.calculator\").resourceId(\"com.google.android.calculator:id/result_final\")").getText());
    }
}