import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxElements {
    WebDriver driver;
    By checkBoxMain = By.cssSelector("svg.rct-icon-uncheck"); // Локатор для основного чекбокса
    By selectedElement = By.xpath("//span[contains(@class, 'text-success')]"); // Локатор для выбранного элемента

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
}