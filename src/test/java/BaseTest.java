import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    TextBoxElements textBoxElements;
    CheckBoxElements checkBoxElements;
    RadioButtonElements radioButtonElements;
    WebTablesPage webTablesPage;
    WebButtonsPage webButtonsPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("pageLoadStrategy", "eager");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        textBoxElements = new TextBoxElements(driver);
        checkBoxElements = new CheckBoxElements(driver);
        radioButtonElements = new RadioButtonElements(driver);
        webTablesPage = new WebTablesPage(driver);
        webButtonsPage = new WebButtonsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}