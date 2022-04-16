package ru.gb.tests.forms;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener.class)
public class SwitchOnFormsPageTest extends BaseTest {

    @Test
    @Description("Проверяем переключение Switch в положение 'on'")
    public void SwitchOnFormsTest() {
        openApp()
                .clickFormsButton()
                .formsSwitchButtonOn()
                .checkSwitchButtonOn();
    }
}
