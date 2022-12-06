import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class TestCase2 {

    public WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        this.driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void test01() {
        this.driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        final String title = this.driver.getTitle();
        assertEquals("Web form", title);

        this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        final WebElement textBox      = this.driver.findElement(By.name("my-text"));
        final WebElement submitButton = this.driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        final WebElement message = this.driver.findElement(By.id("message"));
        final String     value   = message.getText();
        assertEquals("Received!", value);
    }
    @Test
    public void test02() {
        this.driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        final String title = this.driver.getTitle();
        assertEquals("Web form", title);

        this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        final WebElement textBox      = this.driver.findElement(By.name("my-text"));
        final WebElement submitButton = this.driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        final WebElement message = this.driver.findElement(By.id("message"));
        final String     value   = message.getText();
        assertEquals("Received!", value);
    }
}
