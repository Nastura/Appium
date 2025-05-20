package ru.netology.qa;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UIAutomatorTest {

    private AndroidDriver driver;
    UIAutomatorObjects uiAutomatorObjects;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "readmi");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", ".MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);



        driver = new AndroidDriver(getUrl(), desiredCapabilities);
        uiAutomatorObjects = new UIAutomatorObjects(driver);
    }


    @Test
    public void emptyInputField() {
        String expected = "Привет, UiAutomator!";
        uiAutomatorObjects.inputField.isDisplayed();
        uiAutomatorObjects.inputField.sendKeys(UIAutomatorTestData.spaces);
        uiAutomatorObjects.changeText.isDisplayed();
        uiAutomatorObjects.changeText.click();
        uiAutomatorObjects.greetings.isDisplayed();
        String actual = uiAutomatorObjects.greetings.getText();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void textInNewWindow(){
        String expected = UIAutomatorTestData.text1;
        uiAutomatorObjects.inputField.isDisplayed();
        uiAutomatorObjects.inputField.sendKeys(UIAutomatorTestData.text1);
        uiAutomatorObjects.buttonActivity.isDisplayed();
        uiAutomatorObjects.buttonActivity.click();
        uiAutomatorObjects.textWindow.isDisplayed();
        String actual = uiAutomatorObjects.textWindow.getText();
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}