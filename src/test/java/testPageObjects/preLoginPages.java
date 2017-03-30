package testPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.experimental.categories.Category;
import tests.groups.Test;

/**
 * Created by Administrator on 12/22/2016.
 */
public class preLoginPages {
    private WebDriver driver;
    By aboutLink = By.xpath("/html/body/header/nav/div[2]/div[1]/div/nav/ul/li[2]/a");
    By newsLink = By.xpath("/html/body/header/nav/div[2]/div[1]/div/nav/ul/li[3]/a");
    By creditEducationLink = By.cssSelector("body > div.container > ul.nav.nav-pills.hidden-xs > li:nth-child(1) > a");
    By creditImprovementLink = By.cssSelector("body > div.container > ul.nav.nav-pills.hidden-xs > li:nth-child(2) > a");
    By homeBuyingLink = By.cssSelector("body > div.container > ul.nav.nav-pills.hidden-xs > li:nth-child(3) > a");
    By identityTheftLink = By.cssSelector("body > div.container > ul.nav.nav-pills.hidden-xs > li:nth-child(4) > a");
    By personalLoansLink = By.cssSelector("body > div.container > ul.nav.nav-pills.hidden-xs > li:nth-child(5) > a");
    By refinanceLink = By.cssSelector("body > div.container > ul.nav.nav-pills.hidden-xs > li:nth-child(6) > a");
    By FAQLink = By.xpath("/html/body/header/nav/div[2]/div[1]/div/nav/ul/li[3]/a");
    By CQFAQ1 = By.cssSelector("body > div.container > div > div > div:nth-child(4) > a");
    By CQFAQ2 = By.cssSelector("body > div.container > div > div > div:nth-child(5) > a");
    By CQFAQ3 = By.cssSelector("body > div.container > div > div > div:nth-child(6) > a");
    By CQFAQ4 = By.cssSelector("body > div.container > div > div > div:nth-child(7) > a");
    By CQFAQ5 = By.cssSelector("body > div.container > div > div > div:nth-child(8) > a");
    By CQFAQ6 = By.cssSelector("body > div.container > div > div > div:nth-child(9) > a");
    By CQFAQ7 = By.cssSelector("body > div.container > div > div > div:nth-child(10) > a");
    By CQFAQ8 = By.cssSelector("body > div.container > div > div > div:nth-child(11) > a");
    By HLQFAQ1 = By.cssSelector("body > div.container > div > div > div:nth-child(12) > a");
    By HLQFAQ2 = By.cssSelector("body > div.container > div > div > div:nth-child(13) > a");
    By GAQFAQ1 = By.cssSelector("body > div.container > div > div > div:nth-child(14) > a");
    By GAQFAQ2 = By.cssSelector("body > div.container > div > div > div:nth-child(15) > a");
    By GAQFAQ3 = By.cssSelector("body > div.container > div > div > div:nth-child(16) > a");
    By PQFAQ1 = By.cssSelector("body > div.container > div > div > div:nth-child(17) > a");
    By PQFAQ2 = By.cssSelector("body > div.container > div > div > div:nth-child(18) > a");
    By PQFAQ3 = By.cssSelector("body > div.container > div > div > div:nth-child(19) > a");
    By PQFAQ4 = By.cssSelector("body > div.container > div > div > div:nth-child(20) > a");

    public preLoginPages(WebDriver driver, String Environment) {
        this.driver = driver;
        driver.get("https://" + Environment + ".qlcredit.com");
    }

    public void getAboutPage() {
        driver.findElement(aboutLink).click();
    }

    public void getNewsPage() {
        driver.findElement(newsLink).click();
    }

    public void getCreditEducation() {
        driver.findElement(creditEducationLink).click();
    }

    public void getCreditImprovement() {
        driver.findElement(creditImprovementLink).click();
    }

    public void getHomeBuying() {
        driver.findElement(homeBuyingLink).click();
    }

    public void getIdentityTheft() {
        driver.findElement(identityTheftLink).click();
    }

    public void getPersonalLoans() {
        driver.findElement(personalLoansLink).click();
    }

    public void getRefinance() {
        driver.findElement(refinanceLink).click();
    }

    public void getFAQ() {
        driver.findElement(FAQLink).click();
    }

    public void getCQFAQ1() {
        driver.findElement(CQFAQ1).click();
    }

    public void getCQFAQ2() {
        driver.findElement(CQFAQ2).click();
    }

    public void getCQFAQ3() {
        driver.findElement(CQFAQ3).click();
    }

    public void getCQFAQ4() {
        driver.findElement(CQFAQ4).click();
    }

    public void getCQFAQ5() {
        driver.findElement(CQFAQ5).click();
    }

    public void getCQFAQ6() {
        driver.findElement(CQFAQ6).click();
    }

    public void getCQFAQ7() {
        driver.findElement(CQFAQ7).click();
    }

    public void getCQFAQ8() {
        driver.findElement(CQFAQ8).click();
    }

    public void getHLFAQ1() {
        driver.findElement(HLQFAQ1).click();
    }

    public void getHLFAQ2() {
        driver.findElement(HLQFAQ2).click();
    }

    public void getGAQFAQ1() {
        driver.findElement(GAQFAQ1).click();
    }

    public void getGAQFAQ2() {
        driver.findElement(GAQFAQ2).click();
    }

    public void getGAQFAQ3() {
        driver.findElement(GAQFAQ3).click();
    }

    public void getPQFAQ1() {
        driver.findElement(PQFAQ1).click();
    }

    public void getPQFAQ2() {
        driver.findElement(PQFAQ2).click();
    }

    public void getPQFAQ3() {
        driver.findElement(PQFAQ3).click();
    }

    public void getPQFAQ4() {
        driver.findElement(PQFAQ4).click();
    }
}
