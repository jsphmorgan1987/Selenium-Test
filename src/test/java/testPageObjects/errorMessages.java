package testPageObjects;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testPageObjects.accountCreate;
/**
 * Created by Administrator on 1/27/2017.
 */
public class errorMessages {
    private WebDriver driver;

    SoftAssertions softly = new SoftAssertions();
    By signInErrorTextLocation = By.xpath("//*[@id=\"authentication_form\"]/div/div/p[1]");
    String signInErrorText;
    String signInErrorTextAssertion = "The information you've entered does not match our records. If you feel this message is in error, your account may be locked due to excessive login attempts. In this case, please use the forgot password form to reset your password and unlock your account.";
    By emailDoesntMatchLocation = By.xpath("//*[@id=\"questions-about-you\"]/div/div[1]/div[3]/ul/li");
    String emailDoesntMatchText;
    String emailDoesntMatchAssertion = "The email addresses you have entered do not match.";
    String environment;


    public errorMessages(WebDriver driver, String environmentParameter) {
        this.driver = driver;
        environment = environmentParameter;
        driver.get("https://" + environment + ".qlcredit.com");
    }

    public void errorText() {
        WebElement errorText1 = driver.findElement(signInErrorTextLocation);
        signInErrorText = errorText1.getText();
        softly.assertThat(signInErrorText).isEqualTo(signInErrorTextAssertion);
    }

    public void emailMatchErrorText() {
        //driver.findElement();
        WebElement emailMatchError = driver.findElement(emailDoesntMatchLocation);
        emailDoesntMatchText = emailMatchError.getText();
        softly.assertThat(emailDoesntMatchText).isEqualTo(emailDoesntMatchAssertion);
    }


    public void assertAll() {
        softly.assertAll();
    }
}
