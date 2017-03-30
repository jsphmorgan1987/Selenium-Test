package testPageObjects;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.experimental.categories.Category;
import tests.groups.Test;

import java.util.EmptyStackException;

/**
 * Created by jmorgan2 on 7/1/16.
 */
@Category(Test.class)
public class Summary {
    private WebDriver driver;
    By usernameLocator  = By.id("username");
    By passwordLocator  = By.id("password");
    By submitButton     = By.name("login");
    By signIn = By.linkText("Sign In");
    By successMessageLocator = By.linkText("Payment Trending");
    By failureMessageLocator = By.cssSelector(".error");
    By loginFormLocator = By.id("username");
    By closeSymfony = By.className("hide-button");
    By Summ = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[1]/a");
    By accountDetails = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div[3]/div/div[2]/div[3]/div[2]/a");

    String reportSuccess;
    By dt = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[1]/ul/li[1]/a");
    String debtTracker;
    By dti = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[1]/ul/li[2]/a");
    String DebtToIncome;
    By cu = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[1]/ul/li[3]/a");
    String utilization;
    By cs = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[1]/ul/li[4]/a");
    String creditScore;
    By updateIncome = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div[5]/div/div[3]/div[5]/div[2]/a");
    String updateIncomeAssertion;
    By whyCreditMatters = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div[3]/div/div[2]/div[3]/div[1]/a");
    By youNeedToKnow = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div[5]/div/div[3]/div[5]/div[1]/a");
    By useYourCredit = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div[6]/div/div[3]/div[4]/div/a");
    By addingItUp = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div[7]/div/div[3]/div[4]/div/a");
    By equifax = By.xpath("//*[@id=\"eq\"]/img");
    By transunion = By.id("tu");
    By signOutDropDown = By.id("access_my_account");
    By signOut = By.xpath("/html/body/header/nav/div[2]/div[1]/div/nav/ul/div[2]/div/div/div/ul/li/a");
    SoftAssertions softly = new SoftAssertions();
    SoftAssertions eqSoftly = new SoftAssertions();
    String Environment;

    public Summary(WebDriver driver, String environmentParameter) {
        this.driver = driver;
        Environment = environmentParameter;
        driver.get("https://" + Environment + ".qlcredit.com");


        //assertTrue("The Login form is not present",
        //      driver.findElement(loginFormLocator).isDisplayed());
    }
    public void closeSymfony() {
        driver.findElement(closeSymfony).click();
    }

    public void with(String username, String password) {
        driver.findElement(signIn).click();
        driver.findElement(usernameLocator).clear();
        driver.findElement(passwordLocator).clear();
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitButton).click();

    }

    public void accountdetails() {
        WebElement aD = driver.findElement(accountDetails);
        Actions actions = new Actions(driver);
        actions.moveToElement(aD).click().perform();

        WebElement CR = driver.findElement(By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div/div/div[1]/div/h1"));
        reportSuccess = CR.getText();
        driver.findElement(Summ).click();
    }

    public void DebtTracker() {
        driver.findElement(dt).click();
        debtTracker = driver.getCurrentUrl();
        softly.assertThat(debtTracker).isEqualTo("https://" + Environment + ".qlcredit.com/summary#debtTracker");
    }

    public void DTI() {
        driver.findElement(dti).click();
        DebtToIncome = driver.getCurrentUrl();
        softly.assertThat(DebtToIncome).isEqualTo("https://" + Environment + ".qlcredit.com/summary#debtToIncome-summary");
    }

    public void creditUtilization() {
        driver.findElement(cu).click();
        utilization = driver.getCurrentUrl();
        softly.assertThat(utilization).isEqualTo("https://" + Environment + ".qlcredit.com/summary#creditUtilization-summary");
    }

    public void creditS () {
        driver.findElement(cs).click();
        creditScore = driver.getCurrentUrl();
        softly.assertThat(creditScore).isEqualTo("https://" + Environment + ".qlcredit.com/summary#creditScore-summary");
    }

    public void incomeUpdate() {
        driver.findElement(updateIncome).click();
        updateIncomeAssertion = driver.getCurrentUrl();
        softly.assertThat(updateIncomeAssertion).isEqualTo("https://" + Environment + ".qlcredit.com/account#update_income");
        driver.findElement(Summ).click();
    }

    public void accountdetailsEQ() {
        WebElement aD2 = driver.findElement(accountDetails);
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(aD2).click().perform();
        WebElement CR = driver.findElement(By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[2]/div/div/div[1]/div/h1"));
        reportSuccess = CR.getText();
        driver.findElement(Summ).click();
    }

    public void DebtTrackerEQ() {
        driver.findElement(dt).click();
        debtTracker = driver.getCurrentUrl();
        eqSoftly.assertThat(debtTracker).isEqualTo("https://" + Environment + ".qlcredit.com/summary#debtTracker");
    }

    public void DTIEQ() {
        driver.findElement(dti).click();
        DebtToIncome = driver.getCurrentUrl();
        eqSoftly.assertThat(DebtToIncome).isEqualTo("https://" + Environment + ".qlcredit.com/summary#debtToIncome-summary");
    }

    public void creditUtilizationEQ() {
        driver.findElement(cu).click();
        utilization = driver.getCurrentUrl();
        eqSoftly.assertThat(utilization).isEqualTo("https://" + Environment + ".qlcredit.com/summary#creditUtilization-summary");
    }

    public void creditSEQ() {
        driver.findElement(cs).click();
        creditScore = driver.getCurrentUrl();
        eqSoftly.assertThat(creditScore).isEqualTo("https://" + Environment + ".qlcredit.com/summary#creditScore-summary");
    }

    public void incomeUpdateEQ() {
        driver.findElement(updateIncome).click();
        updateIncomeAssertion = driver.getCurrentUrl();
        eqSoftly.assertThat(updateIncomeAssertion).isEqualTo("https://" + Environment + ".qlcredit.com/account#update_income");
        driver.findElement(Summ).click();
    }


    public void creditMatters() {
        driver.findElement(whyCreditMatters).click();
    }

    public void needToKnow() {
        driver.findElement(youNeedToKnow).click();
    }

    public void yourCredit() {
        driver.findElement(useYourCredit).click();
    }

    public void itUp() {
        driver.findElement(addingItUp).click();
    }

    public void equifaxToggle() {
        driver.findElement(Summ).click();
        WebElement element;
        element = driver.findElement(equifax);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void transUnionToggle() {
        driver.findElement(transunion).click();
    }

    public void signOut() {
        driver.findElement(signOutDropDown).click();
        driver.findElement(signOut).click();
    }

   public void assertAll() {
        softly.assertAll();
        eqSoftly.assertAll();
    }
}
