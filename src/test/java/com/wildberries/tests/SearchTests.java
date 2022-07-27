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
public class SearchTests extends TestBase {
    @Test
    @AllureId("11433")
    @Tags({@Tag("SearchPage"), @Tag("web")})
    @DisplayName("Check search is finding correct item")
    void simpleSearchTest() {
        step("Open main page", () ->
                open(Project.config.webUrl()));
        step("Put 'печенье' into search line ", () ->
                mainPage.searchItem("печенье"));
        step("Open main page and put 'печенье' into search line ", () ->
                mainPage.searchItem("печенье"));
        step("Click Enter and check results", () ->
                searchResultPage.checkItem("Печенье"));
    }
}