package com.elena.tests;

import com.elena.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    @Test
    @Description("Check search is finding correct item")
    @DisplayName("Check search is finding correct item")
    void simpleSearchTest() {
        step("Open 'https://www.wildberries.ru/' and put 'печенье' into search line ", () -> {
            mainPage.searchItem("печенье");
        });
        step("Click Enter and check results", () -> {
            mainPage.chekItem("Печенье");
        });
    }

    @Test
    @Description("Check headers menu is visible")
    @DisplayName("Check headers menu is visible")
    void checkHeaders() {
        step("Open 'https://www.wildberries.ru/' and check headers menu delivery is available ", () -> {
            mainPage.checkDeliveryButton();
        });
        step("check headers menu sell on Wildberries is available ", () -> {
            mainPage.checkSellOnWbButton();
        });
        step("check headers menu Work on Wildberries is available ", () -> {
            mainPage.checkWorkAtWbButton();
        });
        step("check headers menu Report Problem on Wildberries is available ", () -> {
            mainPage.checkReportProblemButton();
        });
    }

    @Test
    @Description("Check new tab is opened")
    @DisplayName("Check new tab is opened")
    void openSellPage() {
        step("Open 'https://www.wildberries.ru/' and check headers menu sell on Wildberries is available ", () -> {
            mainPage.openSellOnWbButton();
        });
        step("check new tab is opened", () -> {
            mainPage.switchTab();
        });
    }

    @Test
    @Description("Check chat bot is available")
    @DisplayName("Check chat bot is available")
    void changeCountry() {
        step("Open 'https://www.wildberries.ru/' and check bot is available and click", () -> {
            mainPage.checkChatBotIsAvailable();
        });
        step("check text", () -> {
            mainPage.checkText("Чат поддержки");
        });
    }

    @Test
    @Description("Check logs")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.wildberries.ru/'", () ->
            open("https://www.wildberries.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Disabled
    @Description("Check logs")
    @DisplayName("Page console log should not have errors")
    void radioButton() {
        step("Open 'https://www.wildberries.ru/' and check bot is available and click", () -> {
            mainPage.hoverMenu();
            sleep(2000);
            mainPage.hoverMenu1();
        });
        step("check text", () -> {
            mainPage.clickOnRadioButton("Armenia");
        });
    }
}