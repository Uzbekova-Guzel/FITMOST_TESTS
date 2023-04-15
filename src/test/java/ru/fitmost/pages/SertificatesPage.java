package ru.fitmost.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class SertificatesPage {

    private static final String CERTIFICATE_MAIN_TITLE = "Сертификаты";
    private static final String CERTIFICATE_TYPE_TITLE = "Выберите вид сертификата";

    public SertificatesPage MoveSertificatesPage() {
        $(".main-nav__main-menu").$(withText(CERTIFICATE_MAIN_TITLE)).click();
        $(".certificate__type__title").shouldHave(text(CERTIFICATE_TYPE_TITLE));
        return this;
    }

    public SertificatesPage clickLogoFitmost() {
        $(".main-nav__logo").click();
        return this;
    }
}
