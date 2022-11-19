package spbtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @BeforeAll
    static void beforeConfig(){
        SelenideLogger.addListener("listenerAllure",new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 3000; // Умное ожидание появление элемента на странице
        Configuration.browserSize = "1920x1080"; // Умно
    }
    @BeforeEach
    void before(){
        open(BS.baseUrl);
        BS.logoImg.shouldBe(visible);
    };
    @AfterEach
    void after() {
        closeWebDriver();
    }

    BaseStep BS = new BaseStep();

    @Test
    void LaunchProgramm()
    {
        BS.loginStep();
        BlockingCard();
        UnblockingCard();
    }
    @Step("Блокировка карты")
    void BlockingCard()
    {
        BS.Cards.shouldBe(visible).click();
        BS.BlockCard.shouldBe(visible).click();
        BS.Block.shouldBe(visible).click();
        switchTo().frame($x("//*[@id='confirmation-frame']"));
        BS.Confirm.shouldBe(visible).click();
        BS.Right.shouldHave(text("Заблокирована"));
    }

    @Step("Разблокировка карты")
    void UnblockingCard()
    {
        BS.Unblocking.shouldBe(visible).click();
        switchTo().frame($x("//*[@id='confirmation-frame']"));
        BS.ConfirmUnblocking.shouldBe(visible).click();
        BS.Right.shouldHave(text("Действует"));
    }
    @Test
    void ChangeAvatar()
    {
     BS.loginStep();
     BS.Ava.shouldBe(visible).click();
     switchTo().frame($x("//*[@id='contentbar']/iframe"));
     BS.NewAva.shouldBe(visible).click();
     BS.ConfirmNewAva.shouldBe(visible).click();
     BS.Warning.shouldHave(text("Демо-пользователь не может менять настройки."));
    }
}
