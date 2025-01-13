import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxElements {
    WebDriver driver;

    By fullName = By.xpath("//*[@id='userName']");
    By email = By.xpath("//*[@id='userEmail']");
    By currentAddress = By.xpath("//textarea[@id='currentAddress']");
    By permanentAddress = By.xpath("//*[@id='permanentAddress']");
    By nameCheck = By.xpath("//p[@id='name']");
    By emailCheck = By.xpath("//p[@id='email']");
    By currentAddressCheck = By.xpath("//p[@id='currentAddress']");


    public TextBoxElements(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/text-box");
    }

    public void setUserName(String user, String emailUser, String currentAddr, String permanentAddr) {
        driver.findElement(fullName).sendKeys(user);
        driver.findElement(email).sendKeys(emailUser);
        driver.findElement(currentAddress).sendKeys(currentAddr);
        driver.findElement(permanentAddress).sendKeys(permanentAddr);
        buttonClick();
    }
    public void buttonClick(){
        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
    }
    public boolean fourElementCheck() {
        String enteredName = driver.findElement(fullName).getAttribute("value");
        String displayedName = driver.findElement(nameCheck).getText();
        String enteredEmail = driver.findElement(email).getAttribute("value");
        String displayedEmail = driver.findElement(emailCheck).getText();
        String enteredCurrentAddress = driver.findElement(currentAddress).getAttribute("value");
        String displayedCurrentAddress = driver.findElement(currentAddressCheck).getText();

        return displayedName.contains(enteredName) &&
                displayedEmail.contains(enteredEmail) &&
                displayedCurrentAddress.contains(enteredCurrentAddress);
    }
    public String enteredEmail(String emailToTest) {
        WebElement emailInput = driver.findElement(email);
        emailInput.sendKeys(emailToTest);
        buttonClick();
        WebElement displayedEmailElement = driver.findElement(emailCheck);
        String displayedEmail = displayedEmailElement.getText();
        if (displayedEmail.contains(emailToTest)) {
            return displayedEmail;
        } else {
            return "The displayed email is incorrect!";
        }
    }
    public void fillingMail(String mail){
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='userEmail']"));
        emailInput.sendKeys(mail);
        buttonClick();
    }
    public boolean isEmailFieldErrorClassPresent() {
        WebElement emailInput = driver.findElement(email);
        String classAttribute = emailInput.getAttribute("class");
        return classAttribute.contains("field-error");
    }
}
