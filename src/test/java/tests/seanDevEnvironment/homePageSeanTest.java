package tests.seanDevEnvironment;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.StitchMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 12/19/2016.
 */
public class homePageSeanTest {
    private WebDriver driver;
    private String environment = "sean.dev";
    private Eyes eyes;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        eyes = new Eyes();
        String id = System.getenv("APPLITOOLS_BATCH_ID");
        String name = System.getenv("JOB_NAME");
        BatchInfo mybatch = new BatchInfo(name);
        mybatch.setId(id);
        eyes.setBatch(mybatch);
        eyes.setApiKey("CiemavdUz106lm8VkmufHkDcumcRRK194UKX1pDTGt8xc110");
        eyes.setForceFullPageScreenshot(true);
        eyes.setStitchMode(StitchMode.CSS);
        driver = eyes.open(driver, "QL Credit", "HomePage Sean");
        driver.manage().window().setSize(new Dimension(375,667));
    }

    @Category(tests.groups.Sean.class)
    @Test
    public void screenshot() {
        driver.get("https://sean.dev.qlcredit.com/");
        eyes.checkWindow("iPhone6");
        driver.manage().window().setSize(new Dimension(384,640));
        eyes.checkWindow("Android Medium");
        driver.manage().window().setSize(new Dimension(360,567));
        eyes.checkWindow("Android Small");
        driver.manage().window().setSize(new Dimension(412,659));
        eyes.checkWindow("Android Large");
        driver.manage().window().setSize(new Dimension(414,736));
        eyes.checkWindow("iPhone6+");
        driver.manage().window().setSize(new Dimension(320,480));
        eyes.checkWindow("iPhone4");
        driver.manage().window().setSize(new Dimension(320,568));
        eyes.checkWindow("iPhone5");
        eyes.close();
    }

    @After
    public void TearDown() {
        eyes.abortIfNotClosed();
        driver.close();
    }
}
