package testPageObjects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
/**
 * Created by Administrator on 2/15/2017.
 */
public class accountClose {
    private WebDriver driver;
    By myAccount = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[7]/a");
    By myAccountCoupon = By.xpath("//*[@id=\"scroll-nav\"]/ul/li[9]/a");
    By accountCloseEmail = By.id("qz_account_close_currentEmail");
    By accountClosePassword = By.id("qz_account_close_currentPassword");
    By accountCloseButton = By.id("test12");
    By modalCloseID = By.id("surveyModal");
    By closeCheckBox = By.id("qz_account_close_survey_goals");
    By nextButton = By.id("next");
    By modalConfirmID = By.id("confirmModal");
    By closeMyAccountButton = By.id("closeAccount");
    String environment;
    //*[@id="scroll-nav"]/ul/li[9]/a
    public accountClose(WebDriver driver, String environmentParameter) {
        this.driver = driver;
        environment = environmentParameter;
        driver.get("https://" + environment + ".qlcredit.com/");
    }

    public void goToMyAccount (By myAccountLink) {
        myAccount = myAccountLink;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(myAccount).click();
    }

    public void startClose (String Email) {
        driver.findElement(accountCloseEmail).sendKeys(Email);
        driver.findElement(accountClosePassword).sendKeys("Qup1234!");
        driver.findElement(accountCloseButton).click();
    }

    public void closeAccountSurveyModal () {
        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(modalCloseID));
        WebElement checkBox;
        checkBox = modal.findElement(closeCheckBox);
        checkBox.click();
        WebElement button1;
        button1 = modal.findElement(nextButton);
        button1.click();
    }

    public void finalCloseAccountModal () {
        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(modalConfirmID));
        WebElement input;
        input = modal.findElement(closeMyAccountButton);
        input.click();
    }

}
