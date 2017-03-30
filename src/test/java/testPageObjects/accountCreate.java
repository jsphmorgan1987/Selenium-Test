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
 * Created by jmorgan2 on 9/2/16.
 */
public class accountCreate {

    private WebDriver driver;
    By signIn = By.linkText("Sign In");
    By seeMyScore = By.cssSelector("html.no-js body.homepage header nav.navbar.navbar-default.navbar-fixed-top div.container div.row nav.user-actions ul li.hidden-xs a.btn.btn-success.get-started.active");
    By email1 = By.id("qz_register_partial_email_first");
    By email2 = By.id("qz_register_partial_email_second");
    By password1 = By.id("qz_register_partial_plainPassword_first");
    By password2 = By.id("qz_register_partial_plainPassword_second");
    By nextButton = By.id("createAccountSubmit");
    By fName = By.id("qz_register_user_person_firstName");
    By lName = By.id("qz_register_user_person_lastName");
    By address = By.id("qz_register_user_person_addresses_0_street");
    By cityField = By.id("qz_register_user_person_addresses_0_city");
    By stateField = By.id("qz_register_user_person_addresses_0_state");
    By zipC = By.id("qz_register_user_person_addresses_0_zip");
    By month = By.id("qz_register_user_person_dob_month");
    By day = By.id("qz_register_user_person_dob_day");
    By year = By.id("qz_register_user_person_dob_year");
    By phone = By.id("qz_register_user_person_phone");
    By vaStatus = By.id("qz_register_user_person_militaryStatus");
    By rentOrOwn = By.id("qz_register_user_person_ownershipStatus");
    By sixMonthLived = By.id("qz_register_livedSixMonths");
    By sixMonthBuy = By.id("qz_register_user_person_buyingSoon");
    By income = By.id("qz_register_user_person_income");
    By savings = By.id("qz_register_user_person_savings");
    By agree = By.id("qz_register_terms");
    By socialSecurityNumber = By.id("qz_initial_confirmation_ssn_ssn");
    By acceptAndContinue = By.cssSelector("html.no-js body.default div.container div.row div.col-md-8 form#ssn-submit.active-process button.btn.btn-success");
    By proceed = By.id("proceed");
    By submit = By.xpath("/html/body/div[3]/div/div[1]/form/div[5]/div/button");
    By homePage = By.cssSelector("html.no-js body.homepage div.wrapper div.container div.row.tool_divider_bottom div.col-sm-6.col-sm-offset-1.text-center img.img-responsive.center-block");
    By bypassEmail= By.id("qz_register_partial_bypassEmailVerification");
    By signInLink = By.xpath("/html/body/header/nav/div[2]/div[1]/div/nav/ul/li[4]/a");
    By emailAddress = By.id("username");
    By passWord = By.id("password");
    By closeSymfony = By.className("hide-button");
    By signInButton = By.xpath("//*[@id=\"authentication_form\"]/div/div/div[4]/div/button");
    By brokerContact = By.id("qz_register_user_person_mortgageContact");
    By summaryPage = By.cssSelector("#eq > img");
    By score = By.xpath("/html/body/div[6]/div/div/section/div/div/div[3]/div[1]/div/div/div[3]/div/div/div[1]/a/div/span/strong");
    By tUModal = By.id("tuAgreement");
    By agreeButton = By.xpath("//*[@id=\"tuAgreement\"]/div/div/div/div/div/div/button");
    By couponRedemptionModal = By.id("qlcModal");
    By couponModalButton = By.xpath("//*[@id=\"qlcModal\"]/div/div/div/div/button");
    By signOut = By.xpath("/html/body/header/nav/div[2]/div[1]/div/nav/div/a");
    By nextButton2 = By.xpath("//*[@id=\"createAccountSubmit\"]");
    String firstName;
    String lastName;
    Double SSN;
    String monthDOB;
    String dayDOB;
    String yearDOB;

    String city;
    String state;
    Double zip;
    String fullAddress;
    String zipCode;
    String actualMonth;
    String socialSecurity;
    Integer ZC;
    Integer socialNumber;
    Cell c;
    Double index;
    Integer x;
    String Environment;
    String couponCode;




    public accountCreate(WebDriver driver, String environmentParameter, String couponCodeParameter) {
        this.driver = driver;
        Environment = environmentParameter;
        couponCode = couponCodeParameter;
        driver.get("https://" + Environment + ".qlcredit.com/" + couponCode);
        //assertTrue(driver.findElement(homePageTest).isDisplayed());
    }

    public void excelRead() throws IOException
    {
        String excelFilePath = "C:\\Users\\Administrator\\Documents\\autoaccount.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        index = firstSheet.getRow(0).getCell(15).getNumericCellValue();
        x = index.intValue();

        firstName = firstSheet.getRow(x).getCell(0).getStringCellValue();
        lastName = firstSheet.getRow(x).getCell(1).getStringCellValue();
        SSN = firstSheet.getRow(x).getCell(2).getNumericCellValue();
        monthDOB = new SimpleDateFormat("MMM").format(firstSheet.getRow(x).getCell(3).getDateCellValue());
        dayDOB = new SimpleDateFormat("dd").format(firstSheet.getRow(x).getCell(3).getDateCellValue());
        yearDOB = new SimpleDateFormat("yyyy").format(firstSheet.getRow(x).getCell(3).getDateCellValue());
        fullAddress = firstSheet.getRow(x).getCell(4).getStringCellValue();

        city = firstSheet.getRow(x).getCell(5).getStringCellValue();
        state = firstSheet.getRow(x).getCell(6).getStringCellValue();
        zip = firstSheet.getRow(x).getCell(7).getNumericCellValue();

        socialNumber = SSN.intValue();
        socialSecurity = String.valueOf(socialNumber);
        ZC = zip.intValue();
        zipCode = String.valueOf(ZC);
        x++;
        firstSheet.getRow(0).getCell(15).setCellValue(x);

        FileOutputStream saveFile = new FileOutputStream("C:\\Users\\Administrator\\Documents\\autoaccount.xlsx");
        workbook.write(saveFile);

        inputStream.close();
    }

    public void monthDropDown()
    {
        if (monthDOB.equals("Jan"))
        {
            actualMonth = "January";
        }
        else if (monthDOB.equals("Feb"))
        {
            actualMonth = "February";
        }
        else if (monthDOB.equals("Mar"))
        {
            actualMonth = "March";
        }
        else if (monthDOB.equals("Apr"))
        {
            actualMonth = "April";
        }
        else if (monthDOB.equals("May"))
        {
            actualMonth = "May";
        }
        else if (monthDOB.equals("Jun"))
        {
            actualMonth = "June";
        }
        else if (monthDOB.equals("Jul"))
        {
            actualMonth = "July";
        }
        else if (monthDOB.equals("Aug"))
        {
            actualMonth = "August";
        }
        else if (monthDOB.equals("Sep"))
        {
            actualMonth = "September";
        }
        else if (monthDOB.equals("Oct"))
        {
            actualMonth = "October";
        }
        else if (monthDOB.equals("Nov"))
        {
            actualMonth = "November";
        }
        else if (monthDOB.equals("Dec"))
        {
            actualMonth = "December";
        }
    }

    public void closeSymfony() {
        driver.findElement(closeSymfony).click();
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
        monthDropdown.selectByVisibleText(actualMonth);

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
        Select brokerDropDown = new Select(driver.findElement(brokerContact));
        brokerDropDown.selectByVisibleText("Yes");

        driver.findElement(income).sendKeys(personalIncome);
        driver.findElement(savings).sendKeys(personalSavings);
        WebElement element = driver.findElement(agree);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        driver.findElement(nextButton2).click();
    }

    public void signIn(String email, String password)
    {
        driver.get("https://" + Environment + ".qlcredit.com/" + couponCode);
        driver.findElement(signInLink).click();
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
        /*if (driver.findElement(summaryPage).isDisplayed())
        {
            goodAccount = 1;

        }
        else
        {
            goodAccount = 0;
        }*/

    }

    public void accountData(String Email) throws IOException
    {
        String excelFilePath = "C:\\Users\\Administrator\\Documents\\AccountStuff.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);

        Double y = firstSheet.getRow(0).getCell(7).getNumericCellValue();
        Integer acctIndex = y.intValue();
        firstSheet.getRow(acctIndex).getCell(0).setCellValue(Email);
        firstSheet.getRow(acctIndex).getCell(1).setCellValue(firstName);
        firstSheet.getRow(acctIndex).getCell(2).setCellValue(lastName);
        firstSheet.getRow(acctIndex).getCell(3).setCellValue(socialSecurity);
        firstSheet.getRow(acctIndex).getCell(4).setCellValue(actualMonth);
        firstSheet.getRow(acctIndex).getCell(5).setCellValue(dayDOB);
        firstSheet.getRow(acctIndex).getCell(6).setCellValue(yearDOB);
        //firstSheet.getRow(acctIndex).getCell(8).setCellValue(goodAccount);
        acctIndex++;
        firstSheet.getRow(0).getCell(7).setCellValue(acctIndex);

        FileOutputStream saveFile = new FileOutputStream("C:\\Users\\Administrator\\Documents\\AccountStuff.xlsx");
        workbook.write(saveFile);

        inputStream.close();

    }

    public void closeEmail(String Email) throws IOException {
        String accountCloseEmailFile = "C:\\Users\\Administrator\\Documents\\closeaccountemail.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(accountCloseEmailFile));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        firstSheet.getRow(0).getCell(0).setCellValue(Email);
        FileOutputStream saveFile = new FileOutputStream("C:\\Users\\Administrator\\Documents\\closeaccountemail.xlsx");
        workbook.write(saveFile);

        inputStream.close();
    }

    public void tUAgreement() {
        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(tUModal));
        WebElement agreement;
        agreement = modal.findElement(agreeButton);
        agreement.click();
    }

    public void couponModal() {
        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(couponRedemptionModal));
        WebElement redeemButton;
        redeemButton = modal.findElement(couponModalButton);
        redeemButton.click();
    }


    public void signOut() {
        driver.findElement(signOut).click();
    }



}
