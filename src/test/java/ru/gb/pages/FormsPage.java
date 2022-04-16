package ru.gb.pages;

import com.codeborne.selenide.Condition;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.qameta.allure.Step;
import ru.gb.locators.FormsPageLocators;

import java.awt.image.BufferedImage;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class FormsPage {

    // Метод позволяет работать с локаторами для нужной нам страницы.
    private FormsPageLocators locator() {
        return new FormsPageLocators();
    }

    @Step("Switch в положение 'on'")
    public FormsPage formsSwitchButtonOn() {
        $(locator().formsSwitchButton()).click();
        return new FormsPage();
    }

    @Step("Проверяем что положение Switch действительно 'on'")
    public FormsPage checkSwitchButtonOn() {
        $(locator().formsSwitchButton()).shouldHave(Condition.text("ON"));
        return new FormsPage();
    }

    @Step("Делаем скриншот {imageName} страницы и сравниваем с требованием.")
    public FormsPage checkScreenshot(String imageName, String methodName) {
        // Загружаем ожидаемое изображения для сравнения.
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("src/main/resources/expectedScreenshots/" + imageName);
        // Делаем актуальный скриншот, используя элемент и игнорируя другие части экрана.
        File actualScreenshot = $(locator().formScreen()).screenshot();
        // Загружаем актуальный скриншот.
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("screenshots/actual/" + actualScreenshot.getName());

        // Где будем хранить скриншот с различиями в случае падения теста.
        File resultDestination = new File("diff/diff_" + methodName + ".png");

        // Сравниваем.
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
        return this;
    }
}
