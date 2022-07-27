package com.wildberries.tests;

import com.wildberries.config.Project;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Story("WEB UI Testing")
@Owner("allure8")
public class AuthorizationTests extends TestBase {
    @Test
    @AllureId("11428")
    @Tags({@Tag("AuthPage"), @Tag("web")})
    @DisplayName("Attempt to login without phone number")
    void attemptToLogin() {
        step("Open main page", () ->
                open(Project.config.webUrl()));
        step("Open login page ", () ->
                mainPage.clickToLoginPage());
        step("Click on send code button", () ->
                authPage.clickRequestCode());
        step("Check error message text", () ->
                authPage.checkErrorMessage("Введите номер телефона!"));
    }
}