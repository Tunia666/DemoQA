import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxElements {
    WebDriver driver;
    By checkBoxMain = By.cssSelector("svg.rct-icon-uncheck");
    By selectedElement = By.xpath("//span[contains(@class, 'text-success')]");
    By checkBoxes = By.cssSelector("span.rct-checkbox");
    By expandAllButton = By.cssSelector("svg.rct-icon.rct-icon-expand-all");
    By desktopCheckBox = By.cssSelector("label[for='tree-node-desktop'] span.rct-checkbox");
    By reactCheckBox = By.cssSelector("label[for='tree-node-react'] span.rct-checkbox");
    By veuCheckBox = By.cssSelector("label[for='tree-node-veu'] span.rct-checkbox");
    public CheckBoxElements(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/checkbox");
    }

    public void clickCheckBoxMain() {
        driver.findElement(checkBoxMain).click();
    }

    public boolean isElementSelected() {
        return driver.findElements(selectedElement).size() > 0;
    }

    public void expandAll() {
        driver.findElement(expandAllButton).click();
    }

    public void selectDesktop() {
        driver.findElement(desktopCheckBox).click();
    }

    public void selectReact() {
        driver.findElement(reactCheckBox).click();
    }

    public void selectVeu() {
        driver.findElement(veuCheckBox).click();
    }

    public boolean elementSelected(String elementName) {
        return driver.findElements(selectedElement).stream()
                .anyMatch(element -> element.getText().equalsIgnoreCase(elementName));
    }
}