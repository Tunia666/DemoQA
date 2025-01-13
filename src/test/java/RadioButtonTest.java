import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RadioButtonTest extends BaseTest {

    @Test
    public void testRadioButtonSelection() {
        radioButtonElements.open();
        String result = radioButtonElements.checkActive("Yes");
        assertTrue(result.contains("Yes"), "The result message is incorrect!");
    }

    @Test
    public void testImpressiveRadioButtonSelection() {
        radioButtonElements.open();
        String result = radioButtonElements.checkActive("Impressive");
        assertTrue(result.contains("Impressive"), "The result message is incorrect!");
    }

    @Test
    public void testNoRadioButtonInactive() {
        radioButtonElements.open();
        boolean isNoActive = radioButtonElements.isNoButtonActive();
        assertFalse(isNoActive, "The 'No' button should not be active!");
    }
}