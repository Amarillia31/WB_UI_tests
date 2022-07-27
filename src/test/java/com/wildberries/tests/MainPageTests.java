package com.wildberries.tests;

import com.wildberries.config.Project;
import com.wildberries.helpers.DriverUtils;
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

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Story("WEB UI Testing")
@Owner("allure8")
public class MainPageTests extends TestBase {
    @Test
    @AllureId("11432")
    @Tags({@Tag("MainPage"), @Tag("web")})
    @DisplayName("Check headers menu is visible")
    void checkHeaders() {
        step("Open main page", () ->
                open(Project.config.webUrl()));
        step("Check headers menu delivery is available ", () ->
                mainPage.checkDeliveryButton());
        step("Check headers menu sell on main page is available ", () ->
                mainPage.checkSellOnWbButton());
        step("Check headers menu Work on main page is available ", () ->
                mainPage.checkWorkAtWbButton());
        step("Check headers menu Report Problem on main page is available ", () ->
                mainPage.checkReportProblemButton());
    }

    @Test
    @AllureId("11431")
    @Tags({@Tag("MainPage"), @Tag("web")})
    @DisplayName("Check new tab is opened once user click Sell on Wildberries")
    void openSellPage() {
        step("Open main page", () ->
                open(Project.config.webUrl()));
        step("Check headers menu sell on main page is available ", () ->
                mainPage.openSellOnWbButton());
        step("Switch to the new page", () ->
                mainPage.switchTab(1));
        step("Check new page is opened", () ->
                sellersPage.checkHeader("Сотрудничество с Wildberries"));
    }

    @Test
    @AllureId("11434")
    @Tags({@Tag("MainPage"), @Tag("web")})
    @DisplayName("Check chat bot is available")
    void changeCountry() {
        step("Open main page", () ->
                open(Project.config.webUrl()));
        step("Check chat bot is available and click", () ->
                mainPage.checkChatBotIsAvailable());
        step("Check text", () ->
                mainPage.checkText("Чат поддержки"));
    }

    @Test
    @AllureId("11429")
    @Tags({@Tag("MainPage"), @Tag("web")})
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open main page", () ->
                open(Project.config.webUrl()));
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
                Arguments.of("Киргизия","https://kg.wildberries.ru/"),
                Arguments.of("Узбекистан","https://uz.wildberries.ru/")
        );
    }

    @ParameterizedTest(name = "Check country changed to {0} and verify url {1}.")
    @AllureId("11430")
    @Tags({@Tag("MainPage"), @Tag("web")})
    @MethodSource("methodLocation")
    @DisplayName("Geolocation can be changed.")
    void geolocation(String countryData, String expectedResult) {
        step("Open main page", () ->
                open(Project.config.webUrl()));
        step("Change geolocation", () ->
                mainPage.hoverMenu());
        step("Click on country name", () ->
                mainPage.clickOnGeolocation(countryData));
        step("Check it's correct page", () ->
                mainPage.checkCurrentUrl(expectedResult));
    }
}