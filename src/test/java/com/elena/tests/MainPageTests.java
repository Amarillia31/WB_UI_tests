package com.elena.tests;

import com.elena.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @Description("Check search is finding correct item")
    @DisplayName("Check search is finding correct item")
    void simpleSearchTest() {
        step("Open main page and put 'печенье' into search line ", () -> {
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
        step("Open main page and check headers menu delivery is available ", () -> {
            mainPage.checkDeliveryButton();
        });
        step("check headers menu sell on main page is available ", () -> {
            mainPage.checkSellOnWbButton();
        });
        step("check headers menu Work on main page is available ", () -> {
            mainPage.checkWorkAtWbButton();
        });
        step("check headers menu Report Problem on main page is available ", () -> {
            mainPage.checkReportProblemButton();
        });
    }

    @Test
    @Description("Check new tab is opened once user click Sell on Wildberries")
    @DisplayName("Check new tab is opened once user click Sell on Wildberries")
    void openSellPage() {
        step("Open main page and check headers menu sell on main page is available ", () -> {
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
        step("Open main page and check chat bot is available and click", () -> {
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
        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    static Stream<Arguments> methodLocation() {
        return Stream.of(
                Arguments.of("Армения","https://am.wildberries.ru/"),
                Arguments.of("Беларусь","https://by.wildberries.ru/"),
                Arguments.of("Израиль","https://wildberries.co.il/"),
                Arguments.of("Казахстан","https://kz.wildberries.ru/"),
                Arguments.of("Беларусь","https://by.wildberries.ru/"),
                Arguments.of("Киргизия","https://kg.wildberries.ru/"),
                Arguments.of("Узбекистан","https://uz.wildberries.ru/")
        );
    }
    @ParameterizedTest(name = "check country changed to {0} and verify url {1}")
    @MethodSource("methodLocation")
    @Description("Geolocation")
    @DisplayName("Geolocation can be changed")
    void Geolocation(String countryData, String expectedResult) {
        step("Open main page change geolocation", () -> {
            mainPage.hoverMenu();
        });
        step("Click on country name", () -> {
            mainPage.clickOnGeolocation(countryData);
        });
        step("Check it's correct page", () -> {
            mainPage.checkCurrentUrl(expectedResult);
        });
    }
}