package executors;

import locators.NodesLocators;

public class NodesPage {

    private NodesLocators locators;

    public NodesPage() {
        locators = new NodesLocators();
    }

    public void clickOnRootNodeName() {
        locators.rootNodeName.click();
    }

    public void doubleClickRootNodeName() {
        locators.rootNodeName.doubleClick();
    }

    public void clickOnRootNodeArrow() {
        locators.rootNodeArrow.click();
    }

    public void clickRightOnRootNodeName() {
        locators.rootNodeName.contextClick();
    }

    public void clickOnChangeNameButton() {
        locators.changeNameButton.click();
    }

    public void typeNewName(String newName) {
        locators.newNameInput.val(newName).pressEnter();
    }

    public String verifyChildNodeName(String childNumber) {
        return locators.getChildNodeName(childNumber).getText();
    }

    public String verifyArticleHeader() {
        return locators.header.getText();
    }

    public String verifyRootNodeName() {
        return locators.rootNodeName.getText();
    }
}
