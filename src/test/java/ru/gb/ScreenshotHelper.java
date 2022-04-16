package ru.gb;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class ScreenshotHelper extends BaseTest {

    @Test
    @Description("Создание скриншота главной страницы")
    public void createScreenMainPage() {
        openApp();
        File actualScreenshot = $(MobileBy.AccessibilityId("Home-screen")).screenshot();
    }

    @Test
    @Description("Создание скриншота страницы Forms")
    public void createScreenFormPage() {
        openApp()
                .clickFormsButton();
        File actualScreenshot = $(MobileBy.AccessibilityId("Forms-screen")).screenshot();
    }
}
