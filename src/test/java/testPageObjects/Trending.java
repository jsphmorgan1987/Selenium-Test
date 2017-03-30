package testPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.experimental.categories.Category;
import tests.groups.Test;

/**
 * Created by Administrator on 12/20/2016.
 */
public class Trending {
    private WebDriver driver;
    By trendingLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[3]/a");
    By creditPaymentsLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[3]/ul/li[1]/a");
    By debtToIncomeLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[3]/ul/li[2]/a");
    By creditBalanceLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[3]/ul/li[3]/a");
    By availableCreditLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[3]/ul/li[4]/a");
    By creditUtilizationLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[3]/ul/li[5]/a");
    By creditScoreLink = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[3]/ul/li[6]/a");
    By whyCreditMattersLink = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[3]/div/div/div/div[2]/div[2]/div[9]/div[1]/a");
    By youNeedToKnowLink = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[4]/div/div/div/div[2]/div[2]/div[9]/div[1]/a");
    By knowYourBalancesLink = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[6]/div/div/div/div[2]/div[2]/div[8]/div/a");
    By whyItMattersLink = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[7]/div/div/div/div[2]/div[2]/div[8]/div/a");
    By youAreMoreThanANumberLink = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[7]/div/div/div/div[2]/div[2]/div[6]/div/a");


    public Trending(WebDriver driver, String Environment) {
        this.driver = driver;
        driver.get("https://" + Environment + ".qlcredit.com");
        //driver.findElement(closeSymfony).click();

        //assertTrue("The Login form is not present",
        //      driver.findElement(loginFormLocator).isDisplayed());
    }

    public void getTrending() {
        driver.findElement(trendingLink).click();
    }

    public void getCreditPayments() {
        driver.findElement(creditPaymentsLink).click();
    }

    public void getDebtToIncome() {
        driver.findElement(debtToIncomeLink).click();
    }

    public void getCreditBalance() {
        driver.findElement(creditBalanceLink).click();
    }

    public void getAvailableCredit() {
        driver.findElement(availableCreditLink).click();
    }

    public void getCreditUtilization() {
        driver.findElement(creditUtilizationLink).click();
    }

    public void getCreditScore() {
        driver.findElement(creditScoreLink).click();
    }

    public void getWhyCreditMatters() {
        driver.findElement(whyCreditMattersLink).click();
    }

    public void getYouNeedtoKnow() {
        driver.findElement(youNeedToKnowLink).click();
    }

    public void getKnowYourBalances() {
        driver.findElement(knowYourBalancesLink).click();
    }

    public void getWhyItMatters() {
        driver.findElement(whyItMattersLink).click();
    }

    public void getYouAreMoreThanANumber() {
        driver.findElement(youAreMoreThanANumberLink).click();
    }
}
