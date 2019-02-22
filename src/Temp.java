import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.JVM)
public class Temp {

        protected static WebDriver driver;

        @BeforeClass
        public static void main() {
            String browser = FileRead.getData("BROWSER");

            // we check what browser we going to use for te project

            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", Constants.CHROM_DRIVER);
                driver = new ChromeDriver();
            }
            if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER);
                driver = new FirefoxDriver();
            }
            driver.get(FileRead.getData("URL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }


        // in the next test we going to register to buyme website.
        // we will find elements and use them as we should for the registration process (mostly typing and clicking)

        @Test
        public void tempRegistration() {
            driver.findElement(By.className(Constants.REG_BUTTON)).click();
            driver.findElement(By.className(Constants.REG_LINK)).click();
            driver.findElement(By.id(Registarion.FIRST_NAME)).sendKeys("name");
            driver.findElement(By.id(Registarion.MAIL)).sendKeys("name@ddd.com");
            driver.findElement(By.id(Registarion.PASSWORD)).sendKeys("A1dasdasd");
            driver.findElement(By.id(Registarion.CONFIRM_PASSWORD)).sendKeys("A1dasdasd");
            WebElement elementToClick = driver.findElement(By.className(Registarion.CONFIRM_TERMS));

            // using a javascript command to click the element

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
            driver.findElement(By.className(Registarion.SIGN_IN)).click();
            ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " registration");
        }


        // in the next test we going to search a gift that fits our needs.
        // we will find elements and use them as we should for the registration process (mostly typing and clicking)

        @Test
        public void temoGiftSearch() {
            driver.findElement(By.id(HomePage.PRICE)).click();
            driver.findElement(By.xpath(HomePage.PRICE_RANGE)).click();
            driver.findElement(By.id(HomePage.AREA)).click();
            driver.findElement(By.xpath(HomePage.AREA_SELECT)).click();
            driver.findElement(By.id(HomePage.GIFT_CATEGORY)).click();
            driver.findElement(By.xpath(HomePage.GIFT_SELECT)).click();
            driver.findElement(By.id(HomePage.SEARCH_BAR)).sendKeys("בלה בעמק");
            driver.findElement(By.id(HomePage.SEARCH_BUTTON)).click();
            ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " temp gift search");
        }

    @Test
    public void test(){
        Temp2.pressFive(driver).click();
    }

//    @AfterClass
//    public static void afterClass() {
//        driver.quit();
//    }


}