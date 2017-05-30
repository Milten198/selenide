package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NodesLocators {

    public SelenideElement rootNodeName = $(By.xpath("//a[contains(text(), 'Root')]"));
    public SelenideElement rootNodeArrow = $(".jstree-icon.jstree-ocl");
    public SelenideElement changeNameButton = $($(".vakata-context-hover>a"));
    public SelenideElement newNameInput = $(".jstree-rename-input");
    public SelenideElement header = $(".col-md-9.content-container>h1");

    public SelenideElement getChildNodeName(String childNumber) {
        return $(By.xpath(String.format("//a[text() = 'Child node %s']", childNumber)));
    }
}
