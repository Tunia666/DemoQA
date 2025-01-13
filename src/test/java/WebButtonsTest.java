
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class WebButtonsTest extends BaseTest {

    @Test
    public void checkClickMeButton() {
        webButtonsPage.open();
        webButtonsPage.clickClickMeButton();
        assertTrue(webButtonsPage.isButtonClickedMessageDisplayed(), "Click Me button message not displayed!");
    }

    @Test
    public void checkRightClickMeButton() {
        webButtonsPage.open();
        webButtonsPage.rightClickButton();
        assertTrue(webButtonsPage.isRightClickMessageDisplayed(), "Right-click message not displayed!");
    }

    @Test
    public void checkDoubleClickMeButton() {
        webButtonsPage.open();
        webButtonsPage.doubleClickButton();
        assertTrue(webButtonsPage.isDoubleClickMessageDisplayed(), "Double-click message not displayed!");
    }
}