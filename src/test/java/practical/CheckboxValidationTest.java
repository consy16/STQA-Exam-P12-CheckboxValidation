
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
import static org.junit.Assert.assertFalse;
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
        ).toURI().toString();

        driver.get(filePath);

        // Identify all six checkboxes.
        List<WebElement> checkboxes = driver.findElements(
                By.cssSelector("input[type='checkbox']")
        );

        int totalCheckboxes = checkboxes.size();

        System.out.println("Total Checkboxes: " + totalCheckboxes);
        assertEquals(6, totalCheckboxes);

        // STUDENT TASK 1 : Count initially checked and unchecked checkboxes.

        int checkedCount = 0;
        int uncheckedCount = 0;

        // TASK 1 - WRITE YOUR CODE HERE


        System.out.println("Initially Checked: " + checkedCount);
        System.out.println("Initially Unchecked: " + uncheckedCount);

        assertEquals(2, checkedCount);
        assertEquals(4, uncheckedCount);

        // Select Python checkbox.
        WebElement pythonCheckbox = driver.findElement(
                By.cssSelector("input[value='Python']")
        );

        assertFalse(pythonCheckbox.isSelected());
        pythonCheckbox.click();
        assertTrue(pythonCheckbox.isSelected());

        // Deselect Java checkbox.
        WebElement javaCheckbox = driver.findElement(
                By.cssSelector("input[value='Java']")
        );

        assertTrue(javaCheckbox.isSelected());
        javaCheckbox.click();
        assertFalse(javaCheckbox.isSelected());

        // STUDENT TASK 2 : Recalculate final checkbox counts.

        checkedCount = 0;
        uncheckedCount = 0;

        // TASK 2 - WRITE YOUR CODE HERE


        System.out.println("After Selection:");
        System.out.println("Final Checked: " + checkedCount);
        System.out.println("Final Unchecked: " + uncheckedCount);

        assertEquals(2, checkedCount);
        assertEquals(4, uncheckedCount);

        System.out.println("Checkbox validation completed successfully.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
