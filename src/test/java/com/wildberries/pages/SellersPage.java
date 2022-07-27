package com.wildberries.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SellersPage {
    // locators
    private final SelenideElement headerText = $(".Intro__title--grknp");

    public void checkHeader(String headersText) {
        headerText.shouldHave(text(headersText));
    }
}
