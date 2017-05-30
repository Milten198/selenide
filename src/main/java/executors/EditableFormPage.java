package executors;

import com.codeborne.selenide.Condition;
import locators.EditableFormLocators;

import java.io.File;

public class EditableFormPage {

    private EditableFormLocators locators;

    public EditableFormPage() {
        locators = new EditableFormLocators();
    }

    public static final String NAME = "Max";
    public static final String SURNAME = "Kolonko";
    public static final String NOTE = "Mówię jak jest";
    public static final String PHONE = "800100300";

    public void enableEditionMode() {
        locators.menuDropDown.hover();
        locators.subMenuForm.hover();
        locators.subMenuEditStart.click();
    }

    public EditableFormPage setName() {
        locators.name.val(NAME);
        return this;
    }

    public EditableFormPage setSurname() {
        locators.surname.val(SURNAME);
        return this;
    }

    public EditableFormPage setNote() {
        locators.notes.val(NOTE);
        return this;
    }

    public EditableFormPage setPhone() {
        locators.phone.val(PHONE);
        return this;
    }

    public void uploadPhoto() {
        locators.fileUpload.uploadFile(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Task3\\bob.jpg"));
    }

    public void clickSaveButton() {
        locators.saveButton.click();
    }

    public String getConfirmationMessage() {
        return locators.message.shouldBe(Condition.visible).getText();
    }

    public String getNameFromForm() {
        return locators.name.getValue();
    }

    public String getSurnameFromForm() {
        return locators.surname.getValue();
    }

    public String getNoteFromForm() {
        return locators.notes.getValue();
    }

    public String getPhoneFromForm() {
        return locators.phone.getValue();
    }

    public String getPhotoSrc() {
        return locators.photo.getAttribute("src");
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
