package tests.testEnvironment;

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
import testPageObjects.accountCreate;
import testPageObjects.expertPurchase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Administrator on 11/28/2016.
 */
public class expertTest {
    private WebDriver driver;
    private expertPurchase expert;
    private Eyes eyes;
    private accountCreate account;
    String environment = "test";
    String couponCode = "";
    Date date = new Date();
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyyyHHmmSS");
    String newDate = DATE_FORMAT.format(date);
    String Email = "test.qlcredit+" + newDate + "@gmail.com";
    String password = "Qup1234!";
    String creditCardNumber = "4111111111111111";
    String expirationDate = "1218";
    String cvvCode = "999";

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
        expert = new expertPurchase(driver, environment);
        account = new accountCreate(driver, environment, couponCode);
        driver.manage().window().maximize();
        eyes.setApiKey("CiemavdUz106lm8VkmufHkDcumcRRK194UKX1pDTGt8xc110");
        eyes.setForceFullPageScreenshot(true);
        eyes.setStitchMode(StitchMode.CSS);
        driver = eyes.open(driver, "QL Credit", "Expert Plan");
    }

    @Category(tests.groups.All.class)
    @Test
    public void createAccount() {
        try {
            account.excelRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
        account.monthDropDown();
        account.createAccount(Email, password);
        account.additionalInformation("3137373000", "No", "Live Rent Free", "Yes", "Yes", "123456", "123456");
        account.signOut();
        account.signIn(Email, password);
        System.out.println(Email);
        account.iDVerification("666673615");
        expert.goToPlansPage();
        eyes.checkWindow("Plans Page");
        expert.selectExpert();
        eyes.checkWindow("Expert Details");
        expert.expertBuy();
        eyes.checkWindow("Payment Modal");
        expert.paymentDetails(creditCardNumber, expirationDate, cvvCode);
        try {
            expert.purchase();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eyes.checkWindow("Expert Page");
        eyes.close();

    }

   @After
    public void tearDown() {
        eyes.abortIfNotClosed();
        driver.quit();
    }
}
