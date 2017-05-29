package executors;

import com.codeborne.selenide.Condition;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class EditableFormPage {

    public static final String NAME = "Max";
    public static final String SURNAME = "Kolonko";
    public static final String NOTE = "Mówię jak jest";
    public static final String PHONE = "800100300";

    public void enableEditionMode() {
        $(".dropdown-toggle.menu-border").hover();
        $("#menu1>li>a").hover();
        $("#start-edit").click();
    }

    public EditableFormPage setName() {
        $("#in-name").val(NAME);
        return this;
    }

    public EditableFormPage setSurname() {
        $("#in-surname").val(SURNAME);
        return this;
    }

    public EditableFormPage setNote() {
        $("#in-notes").val(NOTE);
        return this;
    }

    public EditableFormPage setPhone() {
        $("#in-phone").val(PHONE);
        return this;
    }

    public void uploadPhoto() {
        $("#in-file").uploadFile(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Task3\\bob.jpg"));
    }

    public void clickSaveButton() {
        $("#save-btn").click();
    }

    public String getConfirmationMessage() {
        return $(".notifyjs-bootstrap-base.notifyjs-bootstrap-success>span").shouldBe(Condition.visible).getText();
    }

    public String getNameFromForm() {
        return $("#in-name").getValue();
    }

    public String getSurnameFromForm() {
        return $("#in-surname").getValue();
    }

    public String getNoteFrmForm() {
        return $("#in-notes").getValue();
    }

    public String getPhoneFromForm() {
        return $("#in-phone").getValue();
    }

    public String getPhotoSrc() {
        return $(".preview-photo").getAttribute("src");
    }

    public boolean isFormEditable() {
        boolean canNotEdit = false;
        try {
            setName();
        } catch (Throwable e) {
            if (e.getMessage().contains("Element is not currently interactable and may not be manipulated")) {
                canNotEdit = true;
            }
        }
        return canNotEdit;
    }
}
