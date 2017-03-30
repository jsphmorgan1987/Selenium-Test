package tests.kellyDevEnvironment;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testPageObjects.Report;
import testPageObjects.Summary;

/**
 * Created by jmorgan2 on 11/1/16.
 */
public class ReportKellyTest {
    private WebDriver driver;
    private Summary login;
    private Report navigate;
    private String environment = "kbehr.dev";
    private Eyes eyes;



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
        login = new Summary(driver, environment);
        navigate = new Report(driver, environment);
        driver.manage().window().maximize();
        eyes.setApiKey("CiemavdUz106lm8VkmufHkDcumcRRK194UKX1pDTGt8xc110");
        driver = eyes.open(driver, "QL Credit", "Report Kelly");
    }

    @Category({tests.groups.All.class,tests.groups.Kelly.class})
    @Test
    public void linkCheck() {
        login.closeSymfony();
        login.with("gen1973@qlcredit.com", "Qup1234!");
        navigate.getReport();
        eyes.checkWindow("Report");
        navigate.AccountDetails();
        eyes.checkWindow("Account Details");
        navigate.PersonalInfo();
        eyes.checkWindow("Personal Info");
        navigate.CreditInquiries();
        eyes.checkWindow("Credit Inquiries");
        navigate.PublicRecords();
        eyes.checkWindow("Public Records");
        navigate.equifaxToggle();
        eyes.checkWindow("Report EQ");
        navigate.AccountDetailsEQ();
        eyes.checkWindow("Account Details EQ");
        navigate.PersonalInfoEQ();
        eyes.checkWindow("Personal Info EQ");
        navigate.CreditInquiriesEQ();
        eyes.checkWindow("Credit Inquiries EQ");
        navigate.PublicRecordsEQ();
        eyes.checkWindow("Public Records EQ");
        navigate.assertAll();
        eyes.close();
    }

    @After
    public void TearDown () {

        driver.quit();
    }
}
