package ru.fitmost.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AdditionalPage {

    public AdditionalPage checkSectionText(String text) {
        $(".t-body").shouldHave(text(text));
        return this;
    }
}
