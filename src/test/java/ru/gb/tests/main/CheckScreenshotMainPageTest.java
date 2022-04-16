package ru.gb.tests.main;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener.class)
public class CheckScreenshotMainPageTest extends BaseTest {

    @Test
    @Description("Проверяем UI главной страницы с помощью скриншота.")
    public void CheckScreenshotMainPage() {
        openApp()
                .checkScreenshot("mainPage.png", "CheckScreenshotMainPage");
    }
}