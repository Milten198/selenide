package locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CardPaymentLocators {

    public SelenideElement cardType = $("#task8_form_cardType");
    public SelenideElement name = $("#task8_form_name");
    public SelenideElement cardNumber = $("#task8_form_cardNumber");
    public SelenideElement cardCVV = $("#task8_form_cardCvv");
    public SelenideElement monthExpirationDate = $("#task8_form_cardInfo_month");
    public SelenideElement yearExpirationDate = $("#task8_form_cardInfo_year");
    public SelenideElement payButton = $(".btn.btn-primary.col-md-4.pull-right");
    public SelenideElement cardExpirationMessage = $(".list-unstyled>li");
}
