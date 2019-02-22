import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registarion {

    public static final String FIRST_NAME = "ember1011";
    static WebElement firstName(WebDriver driver) {
        return driver.findElement(By.id(FIRST_NAME));
    }

    public static final String MAIL = "ember1013";
    static WebElement mail(WebDriver driver) {
        return driver.findElement(By.id(MAIL));
    }

    public static final String PASSWORD = "valPass";
    static WebElement password(WebDriver driver) {
        return driver.findElement(By.id(PASSWORD));
    }

    public static final String CONFIRM_PASSWORD = "ember1017";
    static WebElement confirmPassword(WebDriver driver) {
        return driver.findElement(By.id(CONFIRM_PASSWORD));
    }

    public static final String CONFIRM_TERMS = "fa";
    static WebElement confirmTerms(WebDriver driver) {
        return driver.findElement(By.className(CONFIRM_TERMS));
    }

    public static final String SIGN_IN = "ui-btn";

    static WebElement signIn(WebDriver driver) {
        return driver.findElement(By.className(SIGN_IN));
    }


    // extras

    public static final String LOG_IN = "orange";
    static WebElement logIn(WebDriver driver) {
        return driver.findElement(By.className(LOG_IN));
    }

    public static final String USER_NAME_ERROR = "parsley-id-12";
    static WebElement userNameError(WebDriver driver) {
        return driver.findElement(By.id(USER_NAME_ERROR));
    }

    public static final String PASSWORD_ERROR = "parsley-id-14";
    static WebElement passwordError(WebDriver driver) {
        return driver.findElement(By.id(PASSWORD_ERROR));
    }



}
