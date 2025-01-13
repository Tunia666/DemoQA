import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TextBoxTest extends BaseTest {

    @Test
    public void validateTextBoxSubmission() {
        textBoxElements.open();
        textBoxElements.setUserName("tunia", "tunia@mail.com",
                "current address", "permanent address");
        assertTrue(textBoxElements.fourElementCheck(),
                "Submitted data does not match displayed data!");
    }
    @Test
    public void validateEnteredEmail() {
        textBoxElements.open();
        String actualDisplayedEmail = textBoxElements.enteredEmail("test@example.com");
        assertTrue(actualDisplayedEmail.contains("test@example.com"), "The displayed email is incorrect!");
    }
    @Test
    public void validateEmailFieldErrorClass() {
        textBoxElements.open();
        textBoxElements.fillingMail("invalidemail.com");
        assertTrue(textBoxElements.isEmailFieldErrorClassPresent(),
                "Field does not have 'field-error' class for invalid email!");
    }
}