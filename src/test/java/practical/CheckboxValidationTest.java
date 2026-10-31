
package practical;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckboxValidationTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkboxIdentificationAndValidation() {

        String filePath = new File(
                "src/test/resources/checkboxes.html"
        ).getAbsolutePath();

        driver.get("file://" + filePath);

        // TASK 1: Identify all six checkboxes using a CSS selector.
        // TODO: Find all checkbox elements and store them in the list.

        
        // TASK 2: Count checked and unchecked checkboxes.
        


        System.out.println("====================================");
        System.out.println("CHECKBOX IDENTIFICATION AND VALIDATION");
        System.out.println("====================================");
        System.out.println("Total checkboxes   : " + totalCheckboxes);
        System.out.println("Checked checkboxes : " + checkedCount);
        System.out.println("Unchecked checkboxes: " + uncheckedCount);

        assertEquals(6, totalCheckboxes);
        assertEquals(2, checkedCount);
        assertEquals(4, uncheckedCount);

        // Locate the Python checkbox using its value.
        WebElement pythonCheckbox = driver.findElement(
        By.cssSelector("input[value='Python']"));

        
       WebElement pythonCheckbox = driver.findElement(
        By.cssSelector("input[value='TODO_PYTHON']"));

        // TODO: Verify it is initially unchecked, click it, and verify it is selected.

        // TASK 3B: Locate the Java checkbox using its value.
        assertFalse(pythonCheckbox.isSelected());
        pythonCheckbox.click();
        assertTrue(pythonCheckbox.isSelected());

        WebElement javaCheckbox = driver.findElement(
        By.cssSelector("input[value='TODO_JAVA']"));

        // TODO: Verify it is initially checked, click it, and verify it is deselected.

        // Recalculate the final checked and unchecked counts.
        WebElement javaCheckbox = driver.findElement(
        By.cssSelector("input[value='Java']"));

            assertTrue(javaCheckbox.isSelected());
        javaCheckbox.click();
        assertFalse(javaCheckbox.isSelected());

        for (WebElement checkbox : checkboxes) 
        {
            if (checkbox.isSelected()) {
            checkedCount++;
            } 
            else {
        uncheckedCount++;
    }
}


        System.out.println("------------------------------------");
        System.out.println("FINAL CHECKBOX STATUS");
        System.out.println("Checked checkboxes : " + checkedCount);
        System.out.println("Unchecked checkboxes: " + uncheckedCount);
        System.out.println("------------------------------------");

        assertEquals(2, checkedCount);
        assertEquals(4, uncheckedCount);

        System.out.println("All checkbox validations passed.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
