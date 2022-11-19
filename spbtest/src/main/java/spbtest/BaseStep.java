package spbtest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class BaseStep
{
    final SelenideElement logoImg = $x("//img[@id='logo']");
    final SelenideElement logInButton = $x("//button[@id='login-button']");
    final SelenideElement userNameInput = $x("//input[@name='username']");
    final SelenideElement passwordInput = $x("//input[@name='password']");
    final SelenideElement smsInput = $x("//input[@id='otp-code']");
    final SelenideElement codeButton = $x("//button[@id='login-otp-button']");
    final SelenideElement logoIn = $x("//a[@id='logo']");
    final String baseUrl = "https://idemo.bspb.ru/";
    final SelenideElement  Cards = $x("//*[@id='cards-overview-index']");
    final SelenideElement BlockCard = $x("//*[@id='card-details-ownbank-10066']/div[2]/div[2]/div[2]/div/div[2]/a");
    final SelenideElement Block = $x("//*[@id='block-card']");
    final SelenideElement Confirm = $x("//*[@id='confirm']");
    final SelenideElement Unblocking =$x("//*[@id='card-details-ownbank-10066']/div[2]/div[2]/div[2]/div/div[1]/a/span");
    final SelenideElement ConfirmUnblocking =$x("//*[@id='confirm']");
    final SelenideElement Right =$x("//*[@id='card-details-ownbank-10066']/div[2]/div[2]/div[1]");
    final SelenideElement Ava =$x("//*[@id='user-avatar']/img");
    final SelenideElement NewAva =$x("//*[@id='avatars']/img[24]");
    final SelenideElement ConfirmNewAva =$x("//*[@id='submit-button']");
    final SelenideElement Warning =$x("//*[@id='alerts-container']/div[2]");
    void loginStep ()
    {
        open(baseUrl);
        logoImg.shouldBe(visible);
        userNameInput.shouldBe(visible).val("demo");
        passwordInput.shouldBe(visible).val("demo");
        logInButton.shouldBe(visible).click();
        smsInput.shouldBe(visible).val("0000");
        codeButton.shouldBe(visible).click();
        logoIn.shouldBe(visible);
    }
}

