package com.wildberries.tests;

import com.wildberries.config.Project;
import com.wildberries.helpers.AllureAttachments;
import com.wildberries.helpers.DriverSettings;
import com.wildberries.helpers.DriverUtils;
import com.wildberries.pages.AuthPage;
import com.wildberries.pages.MainPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.wildberries.pages.SearchResultPage;
import com.wildberries.pages.SellersPage;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    AuthPage authPage = new AuthPage();
    SellersPage sellersPage = new SellersPage();

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
