package locators;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EditableFormLocators {

    public SelenideElement menuDropDown = $(".dropdown-toggle.menu-border");
    public SelenideElement subMenuForm = $("#menu1>li>a");
    public SelenideElement subMenuEditStart = $("#start-edit");
    public SelenideElement name = $("#in-name");
    public SelenideElement surname = $("#in-surname");
    public SelenideElement notes = $("#in-notes");
    public SelenideElement phone = $("#in-phone");
    public SelenideElement fileUpload = $("#in-file");
    public SelenideElement message = $(".notifyjs-bootstrap-base.notifyjs-bootstrap-success>span");
    public SelenideElement photo = $(".preview-photo");
    public SelenideElement saveButton = $("#save-btn");

}
