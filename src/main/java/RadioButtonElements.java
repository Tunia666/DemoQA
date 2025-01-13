import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class RadioButtonElements {
    WebDriver driver;
    By yesRadioButton = By.xpath("//label[@for='yesRadio']");
    By impressiveRadioButton = By.xpath("//label[@class='custom-control-label' and @for='impressiveRadio']");
    By noRadioButton = By.xpath("//input[@id='noRadio']");
    By resultMessage = By.className("text-success");

    public RadioButtonElements(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/radio-button");
    }

    public String checkActive(String button) {
        if (button.equals("Yes")) {
            WebElement label = driver.findElement(yesRadioButton);
            label.click();
        } else {
            WebElement impressiveButton = driver.findElement(impressiveRadioButton);
            impressiveButton.click();
        }
        return driver.findElement(resultMessage).getText();
    }

    public boolean isNoButtonActive() {
        WebElement noRadio = driver.findElement(noRadioButton);
        return noRadio.isEnabled();
    }

}