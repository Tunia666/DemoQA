import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest extends BaseTest {

    @Test
    public void testCheckBoxSelection() {
        checkBoxElements.open();
        checkBoxElements.clickCheckBoxMain();
        assertTrue(checkBoxElements.isElementSelected(), "Элемент не был выбран!");
    }
}