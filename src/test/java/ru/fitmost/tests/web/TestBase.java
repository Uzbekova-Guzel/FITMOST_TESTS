package ru.fitmost.tests.web;

import ru.fitmost.config.WebDriverProvider;
import ru.fitmost.pages.AdditionalPage;
import ru.fitmost.pages.BuyPage;
import ru.fitmost.pages.MainPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.fitmost.pages.SertificatesPage;
import ru.fitmost.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    MainPage mainPage = new MainPage();
    SertificatesPage sertificatesPage = new SertificatesPage();
    AdditionalPage additionalPage = new AdditionalPage();
    BuyPage buyPage = new BuyPage();

    @BeforeAll
    static void setUp() {
        WebDriverProvider.setConfig();
    }

    @BeforeEach
    void addListener() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


    @AfterEach
    void close() {
        closeWebDriver();
    }
}
