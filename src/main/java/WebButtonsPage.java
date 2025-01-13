import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebButtonsPage {
    WebDriver driver;
    By clickMeButton = By.xpath("//button[@type='button' and text()='Click Me']");
    By rightClickButton = By.xpath("//button[@type='button' and text()='Right Click Me']");
    By doubleClickMeButton = By.xpath("//button[@type='button' and text()='Double Click Me']");

    By clickMeMessage = By.id("dynamicClickMessage");
    By rightClickMessage = By.id("rightClickMessage");
    By doubleClickMessage = By.id("doubleClickMessage");

    public WebButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    public void clickClickMeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickMeButton));
        button.click();
    }

    public void rightClickButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(rightClickButton));
        Actions actions = new Actions(driver);
        actions.contextClick(button).perform();
    }

    public void doubleClickButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(doubleClickMeButton));
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
    }

    public boolean isButtonClickedMessageDisplayed() {
        return isMessageDisplayed(clickMeMessage);
    }

    public boolean isRightClickMessageDisplayed() {
        return isMessageDisplayed(rightClickMessage);
    }

    public boolean isDoubleClickMessageDisplayed() {
        return isMessageDisplayed(doubleClickMessage);
    }

    private boolean isMessageDisplayed(By messageLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
            return message.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}