import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest extends BaseTest {

    @Test
    public void testCheckBoxSelection() {
        checkBoxElements.open();
        checkBoxElements.clickCheckBoxMain();
        assertTrue(checkBoxElements.isElementSelected(), "Элемент не был выбран!");
    }

    @Test
    public void testExpandAndSelectSpecificCheckBoxes() {
        checkBoxElements.open();
        checkBoxElements.expandAll();
        checkBoxElements.selectDesktop();
        checkBoxElements.selectReact();
        checkBoxElements.selectVeu();
        boolean checkBoxSelectDesktop = checkBoxElements.elementSelected("Desktop");
        boolean checkBoxSelectReact = checkBoxElements.elementSelected("React");
        boolean checkBoxSelectVeu = checkBoxElements.elementSelected("Veu");
        assertTrue(checkBoxSelectDesktop &&
                checkBoxSelectReact && checkBoxSelectVeu, "Элементы не были выбраны!");
    }
}