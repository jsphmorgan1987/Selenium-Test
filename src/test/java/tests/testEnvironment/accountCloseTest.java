package tests.testEnvironment;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.StitchMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import testPageObjects.accountCreate;
import testPageObjects.accountClose;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2/15/2017.
 */
public class accountCloseTest {
    private WebDriver driver;
    private accountCreate accountcreate;
    private accountClose accountclose;
    private Eyes eyes;
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    Date date = new Date();
    private String environment = "test";
    private By myAccount = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[7]/a");
    private String coupon = "";
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyyyHHmmSS");
    String newDate = DATE_FORMAT.format(date);
    String Email = "test.qlcredit+" + newDate + "@gmail.com";
    String password = "Qup1234!";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\chromedriver.exe");
        eyes = new Eyes();
        String id = System.getenv("APPLITOOLS_BATCH_ID");
        String name = System.getenv("JOB_NAME");
        BatchInfo mybatch = new BatchInfo(name);
        mybatch.setId(id);
        eyes.setBatch(mybatch);
        driver = new ChromeDriver();
        accountcreate = new accountCreate(driver, environment, coupon);
        accountclose = new accountClose(driver, environment);
        driver.manage().window().maximize();
        eyes.setApiKey("CiemavdUz106lm8VkmufHkDcumcRRK194UKX1pDTGt8xc110");
        eyes.setForceFullPageScreenshot(true);
        eyes.setStitchMode(StitchMode.CSS);
        driver = eyes.open(driver, "QL Credit", "Account Close");
    }

    @Category({tests.groups.All.class,tests.groups.Test.class, tests.groups.Markus.class})
    @Test
    public void createAccount() {
        try {
            accountcreate.excelRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountcreate.monthDropDown();
        //eyes.checkWindow("Start");
        accountcreate.createAccount(Email, password);
        //eyes.checkWindow("Additional Information");
        accountcreate.additionalInformation("3137373000", "No", "Live Rent Free", "Yes", "Yes", "123456", "123456");
        //eyes.checkWindow("Email Page");
        //accountcreate.signIn(Email, password);
        //eyes.checkWindow("SSN Page");
        System.out.println(Email);
        accountcreate.iDVerification("666673615");
        //eyes.checkWindow("Question Page");
        /*try {
            accountcreate.accountData(Email);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        accountclose.goToMyAccount(myAccount);
        eyes.checkWindow("My Account Page");
        accountclose.startClose(Email);
        eyes.checkWindow("Survey Modal");
        accountclose.closeAccountSurveyModal();
        eyes.checkWindow("Final Modal");
        accountclose.finalCloseAccountModal();
        eyes.checkWindow("Account Closed");
        eyes.close();

    }

    @After
    public void tearDown() {
        eyes.abortIfNotClosed();
        driver.quit();
    }
}
