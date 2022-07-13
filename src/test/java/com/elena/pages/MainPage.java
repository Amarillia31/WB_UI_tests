package com.elena.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    // locators
    SelenideElement mainPageSearchField = $("#searchInput"),
                    deliveryButton = $(".simple-menu__link.j-wba-header-item[href='/services/besplatnaya-dostavka?desktop=1']"),
                    sellOnWbButton = $(".simple-menu__link.simple-menu__link--sell-on-wb.j-wba-header-item"),
                    workAtWbButton = $(".simple-menu__link.simple-menu__link--employment.j-wba-header-item"),
                    reportProblemButton = $(".btn-chat__text"),
                    countryMenu = $(".simple-menu__link.simple-menu__link--country.j-wba-header-item"),
                    radioButtonCountry = $(".radio-with-text__full-country.hide-mobile"),
                    chatBot = $(".smm-fixed__toggle"),
                    chatHeader = $("h2.chat__header");

    ElementsCollection itemCard = $$(".product-card__brand-name");


    public void searchItem(String productName) {
        mainPageSearchField.setValue(productName).pressEnter();
    }
    public void chekItem(String productName) {
        itemCard.findBy(text(productName)).shouldBe(visible);
    }
    public void checkDeliveryButton() { deliveryButton.shouldBe(visible); }
    public void checkSellOnWbButton() { sellOnWbButton.shouldBe(visible); }
    public void checkWorkAtWbButton() { workAtWbButton.shouldBe(visible); }
    public void checkReportProblemButton() { reportProblemButton.shouldBe(visible); }
    public void openSellOnWbButton() { sellOnWbButton.shouldBe(visible).click(); }
    public void switchTab() { switchTo().window(1); }
    public void hoverMenu() {countryMenu.click();}
    public void hoverMenu1() {radioButtonCountry.click();}
    public void clickOnRadioButton(String countryName) {radioButtonCountry.$(byText(countryName)).click();}
    public void checkChatBotIsAvailable() {chatBot.shouldBe(visible).click();}
    public void checkText(String header) {chatHeader.shouldHave(text(header));}
}
