package tests.testEnvironment;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testPageObjects.errorMessages;
import testPageObjects.Summary;
/**
 * Created by Administrator on 1/27/2017.
 */
public class errorMessagesTest {
    private WebDriver driver;
    private Summary login;
    private errorMessages checkMessage;
    private String environment = "test";
    private Eyes eyes;
    private static BatchInfo batch;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\chromedriver.exe");
        /*eyes = new Eyes();
        String id = System.getenv("APPLITOOLS_BATCH_ID");
        String name = System.getenv("JOB_NAME");
        BatchInfo mybatch = new BatchInfo(name);
        mybatch.setId(id);
        eyes.setBatch(mybatch);*/
        driver = new ChromeDriver();
        login = new Summary(driver, environment);
        checkMessage = new errorMessages(driver, environment);
        driver.manage().window().maximize();
        //eyes.setApiKey("CiemavdUz106lm8VkmufHkDcumcRRK194UKX1pDTGt8xc110");
        //driver = eyes.open(driver, "QL Credit", "Report");
    }

    @Test
    public void linkCheck() {
        login.with("test.qlcredit+011220161932400@gmail", "Qup1234!");
        checkMessage.errorText();
        login.with("test.qlcredit+011220161932400@gmail.com", "Qup1");
        checkMessage.errorText();
        checkMessage.assertAll();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
