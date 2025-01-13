import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxElements {
    WebDriver driver;
    By checkBoxMain = By.cssSelector("svg.rct-icon-uncheck"); // Локатор для основного чекбокса
    By selectedElement = By.xpath("//span[contains(@class, 'text-success')]"); // Локатор для выбранного элемента
    By checkBoxes = By.cssSelector("span.rct-checkbox");
    By expandAllButton = By.cssSelector("svg.rct-icon.rct-icon-expand-all"); // Локатор для кнопки "Expand All"
    By desktopCheckBox = By.cssSelector("label[for='tree-node-desktop'] span.rct-checkbox"); // Локатор для чекбокса "Desktop"
    By reactCheckBox = By.cssSelector("label[for='tree-node-react'] span.rct-checkbox"); // Локатор для чекбокса "React"
    By veuCheckBox = By.cssSelector("label[for='tree-node-veu'] span.rct-checkbox"); // Локатор для чекбокса "Veu"
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
    public void selectSpecificCheckBox(int index) {
        List<WebElement> checkBoxList = driver.findElements(checkBoxes);
        if (index >= 0 && index < checkBoxList.size()) {
            checkBoxList.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка чекбоксов.");
        }
    }
    public boolean isElementSelected(String elementName) {
        List<WebElement> selectedElements = driver.findElements(selectedElement);
        for (WebElement element : selectedElements) {
            if (element.getText().equalsIgnoreCase(elementName)) {
                return true;
            }
        }
        return false;
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