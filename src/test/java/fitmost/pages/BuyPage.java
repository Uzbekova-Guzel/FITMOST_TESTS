package fitmost.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BuyPage {

    private static final String BUY_PAGE_TITLE = "Выберите пакет баллов";

    public BuyPage checkBuyPageTitleText() {
        $(".points-wrapper__title").shouldHave(text(BUY_PAGE_TITLE));
        return this;
    }
}
