package tests;

import com.automation.capabilities.Setup;
import com.automation.utils.TestUtils;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseClass extends TestUtils {

    @BeforeAll
    public void initialize() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Setup.PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Setup.AUTOMATION_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Setup.PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Setup.DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, Setup.UDID);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, new File(Setup.APPLICATION).getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        desiredCapabilities.setCapability("noReset", true);
        try {
            driver = new AppiumDriver(new URL(Setup.APPIUM_URL), desiredCapabilities);
            WebDriverRunner.setWebDriver(driver);
        } catch (Exception e) {
            System.out.println("Cause is: " + e.getCause());
            System.out.println("Message is: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterAll
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
