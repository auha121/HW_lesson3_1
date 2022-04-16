package ru.gb.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormsPageLocators {
    public By formsSwitchButton() {
        return MobileBy.AccessibilityId("switch");
    }

    public By formScreen() {
        return MobileBy.AccessibilityId("Forms-screen");
    }
}
