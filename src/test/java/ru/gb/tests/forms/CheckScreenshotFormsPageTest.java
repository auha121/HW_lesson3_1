package ru.gb.tests.forms;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener.class)
public class CheckScreenshotFormsPageTest extends BaseTest {
    @Test
    @Description("Проверяем UI страницы Forms с помощью скриншота.")
    public void CheckScreenshotFormsPage() {
        openApp()
                .clickFormsButton()
                .checkScreenshot("formPage.png", "CheckScreenshotFormsPage");
    }
}
