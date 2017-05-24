package executors;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NodesPage {

    public void clickOnRootNodeName() {
        $(By.xpath("//a[contains(text(), 'Root')]")).click();
    }

    public void doubleClickRootNodeName() {
        $(By.xpath("//a[contains(text(), 'Root')]")).doubleClick();
    }

    public void clickOnRootNodeArrow() {
        $(".jstree-icon.jstree-ocl").click();
    }

    public void clickRightOnRootNodeName() {
        $(By.xpath("//a[contains(text(), 'Root')]")).contextClick();
    }

    public void clickOnChangeNameButton() {
        $(".vakata-context-hover>a").click();
    }

    public void typeNewName(String newName) {
        $(".jstree-rename-input").val(newName).pressEnter();
    }

    public String verifyChildNodeName(String childNumber) {
        return $(By.xpath(String.format("//a[text() = 'Child node %s']", childNumber))).getText();
    }

    public String verifyArticleHeader() {
        return $(".col-md-9.content-container>h1").getText();
    }

    public String verifyRootNodeName() {
        return $(By.xpath("//a[contains(text(), 'Root')]")).getText();
    }
}
