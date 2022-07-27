package com.wildberries.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    // locators
    private final SelenideElement requestCode = $("#requestCode"),
                                  errorText =$(".field-validation-error") ;

    public void clickRequestCode() {
        requestCode.pressEnter();
    }

    public void checkErrorMessage(String errorMessage) {
        errorText.shouldHave(text(errorMessage));
    }
}
