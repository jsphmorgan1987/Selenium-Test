package testPageObjects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
/**
 * Created by Administrator on 2/17/2017.
 */
public class expertPurchase {
    private WebDriver driver;
    By plansPage = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[4]/a");
    By expertPlan = By.xpath("//*[@id=\"plan-expert\"]/div/div/div/div/a");
    By expertContinue = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[1]/div/div[2]/div[2]/div/a/input");
    By cardNumber = By.id("cardNumber");
    String ccNumber = "4111111111111111";
    By expirationDate = By.id("cardExpiry");
    String expDate = "1218";
    By cvCode = By.id("cardCode");
    String verificationCode = "999";
    By cardHolderName = By.id("cardHolderName");
    By billingZip = By.id("zip");
    By payButton = By.xpath("//*[@id=\"payment-form\"]/div[2]/div[1]/button");
    By confirmPayButton = By.xpath("/html/body/div[3]/div[7]/div/button");
    By closeButton = By.xpath("/html/body/div/div[4]/div[1]/button");
    By ibcFrame = By.id("ibcpayframe-SP-g8spFcj3");
    By expertTab = By.xpath("//*[@id=\"primary-content\"]/div/div[3]/div[1]/div[2]/ul/li[3]/a");
    String Environment;

    public expertPurchase(WebDriver driver,String environmentParameter) {
        this.driver = driver;
        Environment = environmentParameter;
        driver.get("https://" + Environment + ".qlcredit.com/");

    }

    public void goToPlansPage () {
        driver.findElement(plansPage).click();
    }

    public void selectExpert () {
        driver.findElement(expertTab).click();
        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(expertPlan));
        driver.findElement(expertPlan).click();
    }

    public void expertBuy () {
        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(expertContinue));
        driver.findElement(expertContinue).click();
    }

    public void paymentDetails (String ccNumber, String expDate, String verificationCode) {
        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement ibcModal = driver.findElement(ibcFrame);

        driver.switchTo().frame(ibcModal);
        driver.findElement(cardNumber).sendKeys(ccNumber);
        driver.findElement(expirationDate).sendKeys(expDate);
        driver.findElement(cvCode).sendKeys(verificationCode);
        driver.findElement(cardHolderName).sendKeys("Joe");
        driver.findElement(billingZip).sendKeys("48081");
    }

    public void purchase () throws InterruptedException {
        driver.findElement(payButton).click();
        Thread.sleep(5000);
        driver.findElement(confirmPayButton).click();
        driver.findElement(closeButton).click();
    }
}
