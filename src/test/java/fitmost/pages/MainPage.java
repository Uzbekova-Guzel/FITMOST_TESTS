package fitmost.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static final String MAIN_PAGE_TEXT = "Купить абонемент";
    private static final String MORE_MAIN_TITLE = "Еще";
    private static final String LOCATION = "Воронеж";

    public MainPage openPageFitmost() {
        open("/");
        return this;
    }

    public MainPage verifyMainPage() {
        $(".promo__buy").shouldHave(text(MAIN_PAGE_TEXT));
        return this;
    }

    public MainPage openGlobalLocation() {
        $(".city-selector").click();
        return this;
    }

    public MainPage choiceLocation() {
        $(".city-selector__list").$(byText(LOCATION)).click();
        return this;
    }

    public MainPage checkSelectedLocation() {
        $(".service-nav").shouldHave(text(LOCATION));
        return this;
    }
    public MainPage checkHeadersItems(String header) {
        $(".main-nav__main-menu").shouldHave(text(header));
        return this;
    }

    public MainPage openMoreSection() {
        $(".main-nav__main-menu").$(withText(MORE_MAIN_TITLE)).click();
        return this;
    }

    public MainPage selectSection(String section) {
        $(".main-nav__extend-wrapper").$(withText(section)).click();
        return this;
    }

    public MainPage clickBuyButton() {
        $(".promo__btns-buy").click();
        return this;
    }
}

