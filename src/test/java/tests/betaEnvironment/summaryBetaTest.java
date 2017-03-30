package tests.betaEnvironment;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testPageObjects.Summary;

/**
 * Created by Administrator on 12/9/2016.
 */
public class summaryBetaTest {
    private WebDriver driver;
    private Summary navigate;
    private String environment = "beta";
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
        navigate = new Summary(driver, environment);
        driver.manage().window().maximize();
        eyes.setApiKey("CiemavdUz106lm8VkmufHkDcumcRRK194UKX1pDTGt8xc110");
        driver = eyes.open(driver, "QL Credit", "Summary Beta");
    }

    @Category({tests.groups.All.class,tests.groups.Beta.class})
    @Test
    public void linkCheck() {
        navigate.with("jsphmorgan+30@gmail.com", "Ixion2013!");
        eyes.checkWindow("Summary");
        //navigate.accountdetails();
        //eyes.checkWindow("Account Details");
        navigate.DebtTracker();
        eyes.checkWindow("Debt Tracker");
        //navigate.incomeUpdate();
        //eyes.checkWindow("Income Update");
        navigate.creditMatters();
        eyes.checkWindow("Credit Matters");
        navigate.DTI();
        eyes.checkWindow("DTI");
        navigate.needToKnow();
        eyes.checkWindow("Need to Know");
        navigate.creditUtilization();
        eyes.checkWindow("Credit Utilization");
        navigate.yourCredit();
        eyes.checkWindow("Your Credit");
        navigate.creditS();
        eyes.checkWindow("Credit Score");
        navigate.itUp();
        eyes.checkWindow("Adding It Up");
        navigate.equifaxToggle();
        eyes.checkWindow("Equifax Summary");
        //navigate.accountdetailsEQ();
        //eyes.checkWindow("EQ Account Details");
        navigate.DebtTrackerEQ();
        eyes.checkWindow("EQ Debt Tracker");
        //navigate.incomeUpdateEQ();
        //eyes.checkWindow("EQ Income Update");
        navigate.creditMatters();
        eyes.checkWindow("EQ Credit Matters");
        navigate.DTIEQ();
        eyes.checkWindow("EQ DTI");
        navigate.needToKnow();
        eyes.checkWindow("EQ Need to Know");
        navigate.creditUtilizationEQ();
        eyes.checkWindow("EQ Credit Utilization");
        navigate.yourCredit();
        eyes.checkWindow("EQ Your Credit");
        navigate.creditSEQ();
        eyes.checkWindow("EQ Credit Score");
        navigate.itUp();
        eyes.checkWindow("EQ Adding it Up");
        navigate.assertAll();
        eyes.close();
    }

    @After
    public void tearDown() {
        driver.quit();


    }
}
