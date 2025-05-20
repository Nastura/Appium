package ru.netology.qa;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class UIAutomatorObjects {

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public MobileElement inputField;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    //@iOSXCUITFindBy(accessibility = "2")
    public MobileElement changeText;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    //@iOSXCUITFindBy(accessibility = "+")
    public MobileElement greetings;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    //@iOSXCUITFindBy(accessibility = "=")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    //@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"C\"]/preceding::XCUIElementTypeStaticText)[last()]")
    public MobileElement textWindow;

    private AppiumDriver driver;

    public UIAutomatorObjects(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}