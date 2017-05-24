package executors;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CardPaymentPage {

    public void selectCardType(String cardType) {

        $(By.cssSelector("#task8_form_cardType")).selectOption(cardType);
    }

    public void setName(String name) {
        $("#task8_form_name").val(name);
    }

    public void setCardNumber(String cardNumber) {
        $("#task8_form_cardNumber").val(cardNumber);
    }

    public void cvvCode(String cvvCode) {
        $("#task8_form_cardCvv").val(cvvCode);
    }

    public void setMonth(String month) {
        $("#task8_form_cardInfo_month").selectOption(month);
    }

    public void setYear(String year) {
        $("#task8_form_cardInfo_year").selectOption(year);
    }

    public void clickPayButtn() {
        $(".btn.btn-primary.col-md-4.pull-right").click();
    }

    public String verifyMessage() {
        return $(".list-unstyled>li").getText();
    }
}
