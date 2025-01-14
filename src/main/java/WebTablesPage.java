import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTablesPage {
    WebDriver driver;

    By addButton = By.xpath("//button[text()='Add']");
    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By emailField = By.id("userEmail");
    By ageField = By.id("age");
    By salaryField = By.id("salary");
    By departmentField = By.id("department");
    By submitButton = By.id("submit");
    By tableRows = By.cssSelector(".rt-tbody .rt-tr-group");


    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/webtables");
    }

    public boolean isRecordPresent(String firstName) {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(firstName)) {
                return true;
            }
        }
        return false;
    }

    public void deleteRecord(String firstName) {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(firstName)) {
                WebElement deleteButton = row.findElement(By.xpath(".//span[@title='Delete']"));
                deleteButton.click();
                break;
            }
        }
        waitForTableToUpdate();
    }

    public void addNewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        driver.findElement(addButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(ageField).sendKeys(age);
        driver.findElement(salaryField).sendKeys(salary);
        driver.findElement(departmentField).sendKeys(department);
        driver.findElement(submitButton).click();
    }

    public void waitForTableToUpdate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tableRows, 0));
    }

    public void editRecord(String oldFirstName, String newFirstName, String newLastName) {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(oldFirstName)) {
                WebElement editButton = row.findElement(By.xpath(".//span[@title='Edit']"));
                editButton.click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));

                driver.findElement(firstNameField).clear();
                driver.findElement(firstNameField).sendKeys(newFirstName);

                driver.findElement(lastNameField).clear();
                driver.findElement(lastNameField).sendKeys(newLastName);

                driver.findElement(submitButton).click();
                break;
            }
        }
    }
}