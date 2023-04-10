package fitmost;

import fitmost.pages.SertificatesPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public class TestsFitmost extends TestBase {


    @DisplayName("Переход на главную страницу при клике на лого FITMOST")
    @Test
    @Tag("web")
    @Feature("FITMOST web site tests")
    @Story("UI tests")
    @Owner("UzbekovaGV")
    void goMainPageByLogoTest() {
        step("Открыть страницу 'https://www.fitmost.ru/'", () -> {
            mainPage.openPageFitmost();
        });
        step("Перейти во вкладку 'Сертификаты'", () -> {
            sertificatesPage.MoveSertificatesPage();
        });
        step("Кликнуть на логотип FITMOST в левом верхнем углу", () -> {
            sertificatesPage.clickLogoFitmost();
        });
        step("Переход осуществился на главную страницу FITMOST", () -> {
            mainPage.verifyMainPage();
        });
    }

    @DisplayName("Выбор локации доставки")
    @Test
    @Tag("web")
    @Feature("FITMOST web site tests")
    @Story("UI tests")
    @Owner("UzbekovaGV")
    void locationTest() {
        step("Открыть страницу 'https://www.fitmost.ru/'", () -> {
            mainPage.openPageFitmost();
        });
        step("Открыть окно выбора локации", () -> {
            mainPage.openGlobalLocation();
        });
        step("Выбрать локацию", () -> {
            mainPage.choiceLocation();
        });
        step("В заголовке отображается выбранная локация", () -> {
            mainPage.checkSelectedLocation();
        });
    }

    @ValueSource(
            strings = {"Студии", "Занятия", "Онлайн-курсы", "Сертификаты", "Корпоративным клиентам", "Еще"}
    )
    @ParameterizedTest(name = "В заголовке главной страницы отображается раздел {0}")
    @Tag("web")
    @Feature("FITMOST web site tests")
    @Story("UI tests")
    @Owner("UzbekovaGV")
    void sectionsTest(
            String header
    ) {
        step("Открыть страницу 'https://www.fitmost.ru/'", () -> {
            mainPage.openPageFitmost();
        });
        step("Отображаются все разделы в заголовке главной страницы", () -> {
            mainPage.checkHeadersItems(header);
        });
    }

    @CsvFileSource(resources = "/fitmostMorePages.csv")
    @ParameterizedTest(name = "При переходе в дополнительный раздел {0} отображается текст {1}")
    @Tag("web")
    @Feature("FITMOST web site tests")
    @Story("UI tests")
    @Owner("UzbekovaGV")
    void sectionsMoreTest(
            String section,
            String text
    ) {
        step("Открыть страницу 'https://www.fitmost.ru/'", () -> {
            mainPage.openPageFitmost();
    });
        step("Нажать на 'Еще' в заголовке главной страницы", () -> {
            mainPage.openMoreSection();
        });
        step("Перейти в дополнительный раздел'", () -> {
            mainPage.selectSection(section);
        });
        step("Отображается текст дополнительного раздела", () -> {
            additionalPage.checkSectionText(text);
    });

    }

    @DisplayName("Переход на страницу 'Выберите пакет баллов' при клике на 'Купить абонемент'")
    @Test
    @Tag("web")
    @Feature("FITMOST web site tests")
    @Story("UI tests")
    @Owner("UzbekovaGV")
    void goBuyPageTest() {
        step("Открыть страницу 'https://www.fitmost.ru/'", () -> {
            mainPage.openPageFitmost();
        });
        step("Кликнуть 'Купить абонемент'", () -> {
            mainPage.clickBuyButton();
        });
        step("Переход осуществился на страницу покупки пакета баллов", () -> {
            buyPage.checkBuyPageTitleText();
        });
    }
}


