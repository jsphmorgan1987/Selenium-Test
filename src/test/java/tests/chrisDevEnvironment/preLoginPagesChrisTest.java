package tests.chrisDevEnvironment;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testPageObjects.Summary;
import testPageObjects.preLoginPages;

/**
 * Created by Administrator on 12/22/2016.
 */
public class preLoginPagesChrisTest {
    private WebDriver driver;
    private Summary login;
    private preLoginPages navigate;
    private String environment = "chris.dev";
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
        navigate = new preLoginPages(driver, environment);
        driver.manage().window().maximize();
        eyes.setApiKey("CiemavdUz106lm8VkmufHkDcumcRRK194UKX1pDTGt8xc110");
        driver = eyes.open(driver, "QL Credit", "preLoginPages Chris");
    }

    @Category({tests.groups.All.class,tests.groups.Chris.class})
    @Test
    public void linkCheck() {
        login.closeSymfony();
        navigate.getAboutPage();
        eyes.checkWindow("About Page");
        navigate.getNewsPage();
        eyes.checkWindow("News Page");
        navigate.getCreditImprovement();
        eyes.checkWindow("Credit Improvement");
        navigate.getHomeBuying();
        eyes.checkWindow("Home Buying");
        navigate.getIdentityTheft();
        eyes.checkWindow("Identity Theft");
        navigate.getPersonalLoans();
        eyes.checkWindow("Personal Loans");
        navigate.getRefinance();
        eyes.checkWindow("Refinance");
        navigate.getCreditEducation();
        eyes.checkWindow("Credit Education");
        navigate.getFAQ();
        eyes.checkWindow("FAQ");
        /*navigate.getCQFAQ1();
        eyes.checkWindow("CQFAQ1");
        navigate.getCQFAQ1();
        navigate.getCQFAQ2();
        eyes.checkWindow("CQFAQ2");
        navigate.getCQFAQ2();
        navigate.getCQFAQ3();
        eyes.checkWindow("CQFAQ3");
        navigate.getCQFAQ3();
        navigate.getCQFAQ4();
        eyes.checkWindow("CQFAQ4");
        navigate.getCQFAQ4();
        navigate.getCQFAQ5();
        eyes.checkWindow("CQFAQ5");
        navigate.getCQFAQ5();
        navigate.getCQFAQ6();
        eyes.checkWindow("CQFAQ6");
        navigate.getCQFAQ6();
        navigate.getCQFAQ7();
        eyes.checkWindow("CQFAQ7");
        navigate.getCQFAQ7();
        navigate.getCQFAQ8();
        eyes.checkWindow("CQFAQ8");
        navigate.getCQFAQ8();
        navigate.getHLFAQ1();
        eyes.checkWindow("HLFAQ1");
        navigate.getHLFAQ1();
        navigate.getHLFAQ2();
        eyes.checkWindow("HLFAQ2");
        navigate.getHLFAQ2();
        navigate.getGAQFAQ1();
        eyes.checkWindow("GAQFAQ1");
        navigate.getGAQFAQ1();
        navigate.getGAQFAQ2();
        eyes.checkWindow("GAQFAQ2");
        navigate.getGAQFAQ2();
        navigate.getGAQFAQ3();
        eyes.checkWindow("GAQFAQ3");
        navigate.getGAQFAQ3();
        navigate.getPQFAQ1();
        eyes.checkWindow("PQFAQ1");
        navigate.getPQFAQ1();
        navigate.getPQFAQ2();
        eyes.checkWindow("PQFAQ2");
        navigate.getPQFAQ2();
        navigate.getPQFAQ3();
        eyes.checkWindow("PQFAQ3");
        navigate.getPQFAQ3();
        navigate.getPQFAQ4();
        eyes.checkWindow("PQFAQ4");
        navigate.getPQFAQ4();*/
        eyes.close();
    }

    @After
    public void TearDown() {
        eyes.abortIfNotClosed();
        driver.close();
    }
}
