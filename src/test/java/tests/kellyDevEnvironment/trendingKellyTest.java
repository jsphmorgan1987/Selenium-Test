package tests.kellyDevEnvironment;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testPageObjects.Summary;
import testPageObjects.Trending;

/**
 * Created by Administrator on 12/21/2016.
 */
public class trendingKellyTest {
    private WebDriver driver;
    private Summary login;
    private Trending navigate;
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
        navigate = new Trending(driver, environment);
        driver.manage().window().maximize();
        eyes.setApiKey("CiemavdUz106lm8VkmufHkDcumcRRK194UKX1pDTGt8xc110");
        driver = eyes.open(driver, "QL Credit", "Trending Kelly");
    }

    @Category({tests.groups.All.class,tests.groups.Kelly.class})
    @Test
    public void linkCheck() {
        login.closeSymfony();
        login.with("gen1973@qlcredit.com", "Qup1234!");
        navigate.getTrending();
        eyes.checkWindow("Trending");
        navigate.getCreditPayments();
        eyes.checkWindow("Credit Payments");
        navigate.getWhyCreditMatters();
        eyes.checkWindow("Why Credit Matters");
        navigate.getDebtToIncome();
        eyes.checkWindow("Debt To Income");
        navigate.getYouNeedtoKnow();
        eyes.checkWindow("You Need To Know");
        navigate.getCreditBalance();
        eyes.checkWindow("Credit Balance");
        navigate.getKnowYourBalances();
        eyes.checkWindow("Know Your Balances");
        navigate.getAvailableCredit();
        eyes.checkWindow("Available Credit");
        navigate.getCreditUtilization();
        eyes.checkWindow("Credit Utilization");
        navigate.getWhyItMatters();
        eyes.checkWindow("Why It Matters");
        navigate.getCreditScore();
        eyes.checkWindow("Credit Score");

        eyes.close();
    }

    @After
    public void TearDown(){
        eyes.abortIfNotClosed();
        driver.close();
    }

}
