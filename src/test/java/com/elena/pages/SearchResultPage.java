package com.elena.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    // locators
    private final ElementsCollection itemCard = $$(".product-card__brand-name");

    public void checkItem(String productName) {
        itemCard.findBy(text(productName)).shouldBe(visible);}
}
