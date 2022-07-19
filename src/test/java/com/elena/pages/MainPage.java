package com.elena.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    // locators
    private final SelenideElement mainPageSearchField = $("#searchInput"),
                    deliveryButton = $(".simple-menu__link.j-wba-header-item[href='/services/besplatnaya-dostavka?desktop=1']"),
                    sellOnWbButton = $(".simple-menu__link.simple-menu__link--sell-on-wb.j-wba-header-item"),
                    workAtWbButton = $(".simple-menu__link.simple-menu__link--employment.j-wba-header-item"),
                    reportProblemButton = $(".btn-chat__text"),
                    countryMenu = $(".simple-menu__link.simple-menu__link--country.j-wba-header-item"),
                    chatBot = $(".smm-fixed__toggle"),
                    loginPage =$(".j-main-login"),
                    chatHeader = $("h2.chat__header");

    public void searchItem(String productName) {
        mainPageSearchField.setValue(productName).pressEnter();}

    public void checkDeliveryButton() {
        deliveryButton.shouldBe(visible);}

    public void clickToLoginPage() {
        loginPage.click();}

    public void checkSellOnWbButton() {
        sellOnWbButton.shouldBe(visible);}

    public void checkWorkAtWbButton() {
        workAtWbButton.shouldBe(visible);}

    public void checkReportProblemButton() {
        reportProblemButton.shouldBe(visible);}

    public void openSellOnWbButton() {
        sellOnWbButton.shouldBe(visible).click();}

    public void switchTab(int index) {
        switchTo().window(index);}

    public void hoverMenu() {
        countryMenu.click();}

    public void clickOnGeolocation(String CountryName) {
        $(byText(CountryName)).click();}

    public void checkCurrentUrl(String pageUrl) {
        webdriver().shouldHave(url(pageUrl));}

    public void checkChatBotIsAvailable() {
        chatBot.click();}

    public void checkText(String header) {
        chatHeader.shouldHave(text(header));}
}
