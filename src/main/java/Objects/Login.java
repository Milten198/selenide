package Objects;

import static com.codeborne.selenide.Selenide.$;

public class Login {

    private String userName;

    public String getUserName() {
        return $("#LoginForm__username").getValue();
    }

    public void setUserName(String userName) {
        $("#LoginForm__username").val(userName);
    }
}
