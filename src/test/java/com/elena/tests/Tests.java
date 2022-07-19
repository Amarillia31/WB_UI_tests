package com.elena.tests;

import com.elena.helpers.DriverUtils;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Story("WEB UI Testing")
@Owner("allure8")

public class Tests extends TestBase {
    @Test
    @AllureId("11433")
    @Tags({@Tag("SearchPage"),@Tag("web")})
    @DisplayName("Check search is finding correct item")
    void simpleSearchTest() {
        step("Open main page and put 'печенье' into search line ", () -> {
            mainPage.searchItem("печенье");
        });
        step("Click Enter and check results", () -> {
            searchResultPage.checkItem("Печенье");
        });
    }

    @Test
    @AllureId("11428")
    @Tags({@Tag("AuthPage"),@Tag("web")})
    @DisplayName("Attempt to login without phone number")
    void attemptToLogin() {
        step("Open login page ", () -> {
            mainPage.clickToLoginPage();
        });
        step("Click on send code button", () -> {
            authPage.clickRequestCode();
        });
        step("Check error message text", () -> {
            authPage.checkErrorMessage("Введите номер телефона!");
        });
    }

    @Test
    @AllureId("11432")
    @Tags({@Tag("MainPage"),@Tag("web")})
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
    @AllureId("11431")
    @Tags({@Tag("MainPage"),@Tag("web")})
    @DisplayName("Check new tab is opened once user click Sell on Wildberries")
    void openSellPage() {
        step("Open main page and check headers menu sell on main page is available ", () -> {
            mainPage.openSellOnWbButton();
        });
        step("check new tab is opened", () -> {
            mainPage.switchTab(1);
        });
    }

    @Test
    @AllureId("11434")
    @Tags({@Tag("MainPage"),@Tag("web")})
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
    @AllureId("11429")
    @Tags({@Tag("MainPage"),@Tag("web")})
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

    @ParameterizedTest(name = "Check country changed to {0} and verify url {1}.")
    @AllureId("11430")
    @Tags({@Tag("MainPage"),@Tag("web")})
    @MethodSource("methodLocation")
    @DisplayName("Geolocation can be changed.")
    void geolocation(String countryData, String expectedResult) {
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