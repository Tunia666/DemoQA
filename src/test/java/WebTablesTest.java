import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class WebTablesTest extends BaseTest {
    @Test
    public void checkAddRecord() {
        webTablesPage.open();
        webTablesPage.addNewRecord("Tunia", "Prilepskaya",
                "tunia@mail.com", "25", "500000", "IT");
        assertTrue(webTablesPage.isRecordPresent("Tunia"), "Record was not added!");
    }

    @Test
    public void checkDeleteRecord(){
        webTablesPage.open();
        webTablesPage.addNewRecord("Tunia", "Prilepskaya",
                "tunia@mail.com", "25", "500000", "IT");
        webTablesPage.waitForTableToUpdate();
        webTablesPage.deleteRecord("Tunia");
        webTablesPage.waitForTableToUpdate();
        assertFalse(webTablesPage.isRecordPresent("Tunia"), "Record was not deleted!");
    }

    @Test
    public void checkEditRecord() {
        webTablesPage.open();
        webTablesPage.addNewRecord("Tunia", "Prilepskaya",
                "tunia@mail.com", "25", "500000", "IT");
        webTablesPage.waitForTableToUpdate();
        webTablesPage.editRecord("Tunia", "Anna", "Cheburek");
        webTablesPage.waitForTableToUpdate();
        assertTrue(webTablesPage.isRecordPresent("Anna"), "Record was not edited!");
    }
}