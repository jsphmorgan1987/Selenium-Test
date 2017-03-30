package LeadPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 12/14/2016.
 */
public class signedInLeadRefi {
    private WebDriver driver;
    By signIn = By.linkText("Sign In");
    By seeMyScore = By.cssSelector("html.no-js body.homepage header nav.navbar.navbar-default.navbar-fixed-top div.container div.row nav.user-actions ul li.hidden-xs a.btn.btn-success.get-started.active");
    By email1 = By.id("qz_register_partial_email_first");
    By email2 = By.id("qz_register_partial_email_second");
    By password1 = By.id("qz_register_partial_plainPassword_first");
    By password2 = By.id("qz_register_partial_plainPassword_second");
    By nextButton = By.id("createAccountSubmit");
    By fName = By.id("qz_register_user_persons_0_firstName");
    By lName = By.id("qz_register_user_persons_0_lastName");
    By address = By.id("qz_register_user_persons_0_addresses_0_street");
    By cityField = By.id("qz_register_user_persons_0_addresses_0_city");
    By stateField = By.id("qz_register_user_persons_0_addresses_0_state");
    By zipC = By.id("qz_register_user_persons_0_addresses_0_zip");
    By month = By.id("qz_register_user_persons_0_dob_month");
    By day = By.id("qz_register_user_persons_0_dob_day");
    By year = By.id("qz_register_user_persons_0_dob_year");
    By phone = By.id("qz_register_user_persons_0_phone");
    By vaStatus = By.id("qz_register_user_persons_0_militaryStatus");
    By rentOrOwn = By.id("qz_register_user_persons_0_ownershipStatus");
    By sixMonthLived = By.id("qz_register_livedSixMonths");
    By sixMonthBuy = By.id("qz_register_user_persons_0_buyingSoon");
    By income = By.id("qz_register_user_persons_0_income");
    By savings = By.id("qz_register_user_persons_0_savings");
    By agree = By.id("qz_register_terms");
    By socialSecurityNumber = By.id("qz_initial_confirmation_ssn_ssn");
    By acceptAndContinue = By.cssSelector("html.no-js body.default div.container div.row div.col-md-8 form#ssn-submit.active-process button.btn.btn-success");
    By proceed = By.id("proceed");
    By submit = By.cssSelector("body > div.container > div > div.col-md-8.col-sm-12 > form > div:nth-child(6) > div > button");
    By homePage = By.cssSelector("html.no-js body.homepage div.wrapper div.container div.row.tool_divider_bottom div.col-sm-6.col-sm-offset-1.text-center img.img-responsive.center-block");
    By bypassEmail= By.id("qz_register_partial_bypassEmailVerification");
    By signInLink = By.cssSelector("html.no-js body.default header nav.navbar.navbar-default.navbar-fixed-top div.container div.row nav.user-actions ul li.hidden-xs a.active");
    By emailAddress = By.id("username");
    By passWord = By.id("password");
    By closeSymfony = By.className("hide-button");
    By signInButton = By.cssSelector("html.no-js body.default div.container div.row div.col-md-6.col-sm-12 form#authentication_form.login-form div.row div.col-md-12 div.row div.col-xs-4 button.btn.btn-success.btn-block");
    By brokerContact = By.id("qz_register_user_persons_0_mortgageContact");
    By summaryPage = By.cssSelector("#eq > img");
    By score = By.xpath("/html/body/div[6]/div/div/section/div/div/div[3]/div[1]/div/div/div[3]/div/div/div[1]/a/div/span/strong");
    By mortgageInsiders = By.id("qz_register_user_persons_0_partnerCompany");
    By solutionsButton = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div[5]/div/div[3]/div[7]/div[2]/p[2]/a[1]");
    By purchaseButton = By.xpath("//*[@id=\"primary-content\"]/div[1]/div/div/div[3]/form/div[1]/button");
    By refinanceButton = By.xpath("//*[@id=\"primary-content\"]/div[1]/div/div/div[3]/form/div[2]/button");
    String firstName = "PAULETTE";
    String lastName = "SSKYBLUE";
    Double SSN = 666691060.0;
    String monthDOB = "November";
    String dayDOB = "02";
    String yearDOB = "1993";
    Double addNumber = 334455.0;
    String streetName = "PARROT";
    String streetSuffix = "ST";
    String city = "LOWNDESBORO";
    String state = "AL";
    Double zip = 36752.0;
    String fullAddress;
    String zipCode;
    String actualMonth;
    String socialSecurity;
    Integer ZC;
    Integer socialNumber;

    public signedInLeadRefi(WebDriver driver) {
        this.driver = driver;
        driver.get("https://test.qlcredit.com/");
        assertTrue(driver.findElement(homePage).isDisplayed());
    }

    public void excelRead() throws IOException
    {
        socialNumber = SSN.intValue();
        socialSecurity = String.valueOf(socialNumber);
        Integer address = addNumber.intValue();
        String addressNumber = String.valueOf(address);
        ZC = zip.intValue();
        zipCode = String.valueOf(ZC);

        fullAddress = addressNumber + " " + streetName + " " + streetSuffix;
    }


    public void createAccount(String email, String password)
    {
        driver.findElement(closeSymfony).click();
        driver.findElement(seeMyScore).click();
        driver.findElement(email1).sendKeys(email);
        driver.findElement(email2).sendKeys(email);
        driver.findElement(password1).sendKeys(password);
        driver.findElement(password2).sendKeys(password);
        driver.findElement(bypassEmail).click();
        driver.findElement(nextButton).click();
    }

    public void additionalInformation(String homePhone, String veteran, String ownerShipStatus, String lived, String buying, String personalIncome, String personalSavings)
    {
        driver.findElement(fName).sendKeys(firstName);
        driver.findElement(lName).sendKeys(lastName);
        driver.findElement(address).sendKeys(fullAddress);
        driver.findElement(cityField).sendKeys(city);

        Select stateDropdown = new Select(driver.findElement(stateField));
        stateDropdown.selectByVisibleText(state);

        driver.findElement(zipC).sendKeys(zipCode);

        Select monthDropdown = new Select(driver.findElement(month));
        monthDropdown.selectByVisibleText(monthDOB);

        Select dayDropdown = new Select(driver.findElement(day));
        dayDropdown.selectByVisibleText(dayDOB);

        Select yearDropdown = new Select(driver.findElement(year));
        yearDropdown.selectByVisibleText(yearDOB);

        driver.findElement(phone).sendKeys(homePhone);

        Select vaDropdown = new Select(driver.findElement(vaStatus));
        vaDropdown.selectByVisibleText(veteran);

        Select rentOrOwnDropdown = new Select(driver.findElement(rentOrOwn));
        rentOrOwnDropdown.selectByVisibleText(ownerShipStatus);

        Select sixMonthLivedDropDown = new Select(driver.findElement(sixMonthLived));
        sixMonthLivedDropDown.selectByVisibleText(lived);

        Select buyingDropdown = new Select(driver.findElement(sixMonthBuy));
        buyingDropdown.selectByVisibleText(buying);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*Select brokerDropDown = new Select(driver.findElement(brokerContact));
        brokerDropDown.selectByVisibleText("Yes");*/

        /*Select mortgageInsiderDropDown = new Select(driver.findElement(mortgageInsiders));
        mortgageInsiderDropDown.selectByVisibleText("1010 Data");*/

        driver.findElement(income).sendKeys(personalIncome);
        driver.findElement(savings).sendKeys(personalSavings);
        WebElement element = driver.findElement(agree);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.findElement(nextButton).click();
    }

    public void signIn(String email, String password)
    {
        //driver.findElement(signInLink).click();
        driver.get("https://test.qlcredit.com/sign-in");
        driver.findElement(emailAddress).sendKeys(email);
        driver.findElement(passWord).sendKeys(password);
        driver.findElement(signInButton).click();

    }

    public void iDVerification(String SSN)
    {
        driver.findElement(socialSecurityNumber).sendKeys(socialSecurity);
        driver.findElement(acceptAndContinue).click();
        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("qlcModal")));
        WebElement input;
        input = modal.findElement(proceed);
        input.click();
        WebElement element;
        element = driver.findElement(submit);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void solution () {
        driver.findElement(solutionsButton).click();
    }

    public void purchase () {
        driver.findElement(purchaseButton).click();
    }

    public void refi () {
        driver.findElement(refinanceButton).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
