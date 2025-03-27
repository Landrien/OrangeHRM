import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;


import java.io.IOException;
import java.time.Duration;

public class BaseTest {

   public static WebDriver driver;
    static WebDriverWait wait;
    static ExtentReports extent;
    static ExtentTest test;


    @BeforeMethod
    public void setup(ITestResult result) {

        String Browser = ConfigReader.getProperty("Browser").toLowerCase();
        Boolean hea = Boolean.valueOf(ConfigReader.getProperty("headless"));
        switch (Browser) {
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                if (hea) {
                    options.addArguments("--headless");
                }
                options.addArguments("--incognito");
                driver = new EdgeDriver(options);
            }
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (hea) {
                    options.addArguments("--headless");
                }
                options.addArguments("--incognito");
                driver = new FirefoxDriver(options);
            }
            case "chrome", default -> {
                ChromeOptions options = new ChromeOptions();
                if (hea) {
                    options.addArguments("--headless");
                }
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
            }
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("URL"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.withTimeout(Duration.ofSeconds(2));
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException {
        driver.quit();

    }

    @AfterTest
    public void teardownTest() {


    }

}
