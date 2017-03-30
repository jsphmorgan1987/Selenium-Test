package testPageObjects;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.experimental.categories.Category;
import tests.groups.Test;

/**
 * Created by jmorgan2 on 10/18/16.
 */
public class Report {
    private WebDriver driver;
    By creditReportLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[2]/a");
    String creditReportAssertionText;
    By accountDetailsLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[2]/ul/li[1]/a");
    String accountDetailsAssertionText;
    By accountDetailsExpandAll = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[3]/div/div/div/div/div[2]/div/div[2]/div/a");
    By personalInfoLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[2]/ul/li[2]/a");
    String personalInfoAssertionText;
    By creditInquiresLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[2]/ul/li[3]/a");
    String creditInquiriesAssertionText;
    By publicRecordsLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[2]/ul/li[4]/a");
    String publicRecordsAssertionText;
    By collectionsLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[2]/ul/li[5]/a");
    String collectionsAssertionText;
    By yourCreditExplained = By.xpath("//*[@id=\"inquiry-listing\"]/div[9]/div/a/text()");
    By howToTakeAction = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[4]/div/div/div[1]/div/div[3]/div[2]/div/a/text()");
    By closeSymfony = By.className("hide-button");
    SoftAssertions softly = new SoftAssertions();
    SoftAssertions eqSoftly = new SoftAssertions();
    By equifax = By.id("eq");
    By transunion = By.id("tu");
    String Environment;

    public Report(WebDriver driver, String environmentParameter) {
        this.driver = driver;
        Environment = environmentParameter;
        driver.get("https://" + Environment + ".qlcredit.com");
        //driver.findElement(closeSymfony).click();

        //assertTrue("The Login form is not present",
        //      driver.findElement(loginFormLocator).isDisplayed());
    }

    public void getReport() {
        driver.findElement(creditReportLink).click();
        creditReportAssertionText = driver.getCurrentUrl();
        softly.assertThat(creditReportAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report");
    }

    public void AccountDetails() {
        driver.findElement(accountDetailsLink).click();
        accountDetailsAssertionText = driver.getCurrentUrl();
        softly.assertThat(accountDetailsAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report#accountDetails");
        //driver.findElement(accountDetailsExpandAll).click();
        //driver.findElement(yourCreditExplained).click();
    }

    public void PersonalInfo () {
        driver.findElement(personalInfoLink).click();
        personalInfoAssertionText = driver.getCurrentUrl();
        softly.assertThat(personalInfoAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report#personalInformation");
        //driver.findElement(howToTakeAction).click();
    }

    public void CreditInquiries () {
        driver.findElement(creditInquiresLink).click();
        creditInquiriesAssertionText = driver.getCurrentUrl();
        softly.assertThat(creditInquiriesAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report#creditInquiries");
    }

    public void PublicRecords () {
        driver.findElement(publicRecordsLink).click();
        publicRecordsAssertionText = driver.getCurrentUrl();
        softly.assertThat(publicRecordsAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report#publicRecords");
    }

    public void Collections () {
        driver.findElement(collectionsLink).click();
        collectionsAssertionText = driver.getCurrentUrl();
    }

    public void AccountDetailsEQ () {
        driver.findElement(accountDetailsLink).click();
        accountDetailsAssertionText = driver.getCurrentUrl();
        softly.assertThat(accountDetailsAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report#accountDetails");
        //driver.findElement(accountDetailsExpandAll).click();
        //driver.findElement(yourCreditExplained).click();
    }

    public void PersonalInfoEQ () {
        driver.findElement(personalInfoLink).click();
        personalInfoAssertionText = driver.getCurrentUrl();
        softly.assertThat(personalInfoAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report#personalInformation");
        //driver.findElement(howToTakeAction).click();
    }

    public void CreditInquiriesEQ () {
        driver.findElement(creditInquiresLink).click();
        creditInquiriesAssertionText = driver.getCurrentUrl();
        softly.assertThat(creditInquiriesAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report#creditInquiries");
    }

    public void PublicRecordsEQ () {
        driver.findElement(publicRecordsLink).click();
        publicRecordsAssertionText = driver.getCurrentUrl();
        softly.assertThat(publicRecordsAssertionText).isEqualTo("https://" + Environment + ".qlcredit.com/credit/report#publicRecords");
    }

    public void CollectionsEQ () {
        driver.findElement(collectionsLink).click();
        collectionsAssertionText = driver.getCurrentUrl();
    }
    public void equifaxToggle() {
        driver.findElement(creditReportLink).click();
        WebElement element;
        element = driver.findElement(equifax);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void transUnionToggle() {
        driver.findElement(transunion).click();
    }

    public void assertAll() {
        softly.assertAll();
        eqSoftly.assertAll();
    }

}
