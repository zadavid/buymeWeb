import com.aventstack.extentreports.Status;
import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.DEFAULT)
public class Main {

    protected static WebDriver driver;

    // before every test we will open the browser and load the project website "buyme"
    // the URL and the browser type data will be load from the xml file
    // we make sure the window will be maximize, and we'll allow every action to have 10 seconds buffer time

    @BeforeClass
    public static void main(){
        String browser = FileRead.getData("BROWSER");

        // we check what browser we going to use for te project

                if(browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", Constants.CHROM_DRIVER);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                }
                if(browser.equals("firefox")) {
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
    public void registration(){
        Constants.regButton(driver).click();
        Constants.regLink(driver).click();
        Registarion.firstName(driver).sendKeys("name");
        Registarion.mail(driver).sendKeys("name@ddfaqwaffd.com");
        Registarion.password(driver).sendKeys("A1dasdasd");
        Registarion.confirmPassword(driver).sendKeys("A1dasdasd");
        WebElement elementToClick = Registarion.confirmTerms(driver);

        // using a javascript command to click the element

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", elementToClick);
        Registarion.signIn(driver).click();
        ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " registration");
    }


    // in the next test we going to search a gift that fits our needs.
    // we will find elements and use them as we should for the registration process (mostly typing and clicking)

    @Test
    public void giftSearch() {
        HomePage.price(driver).click();
        HomePage.priceRange(driver).click();
        HomePage.area(driver).click();
        HomePage.areaSelect(driver).click();
        HomePage.giftCategory(driver).click();
        HomePage.giftSelect(driver).click();
        HomePage.searchBar(driver).sendKeys("בלה בעמק");
        HomePage.searchButton(driver).click();
        ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " gift search");
    }


    // in the next test we going to choose the gift we want
    // we will find elements and use them as we should for the registration process (mostly typing and clicking)

    @Test
    public void giftPick() throws InterruptedException {
         // used navigate for the test
//        driver.navigate().to(ChooseGift.URL_TEST);

        // let the page to load and check that the web page we loaded os the right one (with assert)

        Thread.sleep(2000);
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(ChooseGift.URL_TEST, currentURL);
        ChooseGift.belaRestLink(driver).click();
        ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " gift Pick");
    }


    // in the next test we going to fill all the details of the gift sender and receiver
    // we will find elements and use them as we should for the registration process (mostly typing and clicking)

    @Test
    public void senderReceiver() throws InterruptedException {
        // used navigate for the test
//        driver.navigate().to(SenderReceiverInfo.TEST_START_PAGE);

        Thread.sleep(3000);
        SenderReceiverInfo.setPrice(driver).sendKeys("50");
        SenderReceiverInfo.selectButton(driver).click();
        SenderReceiverInfo.someOneElse(driver).click();
        SenderReceiverInfo.giftTo(driver).sendKeys("David");
        SenderReceiverInfo.giftFrom(driver).sendKeys("Doron");
        SenderReceiverInfo.clickEvent(driver).click();
        SenderReceiverInfo.selectEvent(driver).click();
        WebElement webTextArea = SenderReceiverInfo.textArea(driver);

        // clearing the text area and write the text we want

        webTextArea.clear();
        webTextArea.sendKeys("text area test");

        // loading a picture

        SenderReceiverInfo.uploadPic(driver).sendKeys(SenderReceiverInfo.PICTURE);

        // i ues javascript command to mark the send later so i can check after this i can mark send now option

        WebElement sendLater = SenderReceiverInfo.sendItLater(driver);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", sendLater);
        SenderReceiverInfo.sendItNow(driver).click();
        SenderReceiverInfo.sendByMail(driver).click();
        SenderReceiverInfo.typeMail(driver).sendKeys("name@ddd.com");
        SenderReceiverInfo.saveMailButton(driver).click();
        ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " sender receiver");
        WebElement payButton = SenderReceiverInfo.payButton(driver);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", payButton);
    }

    //----------------------------------------------------------------------------------
    // Extras

    // in the next test we going to "get" the elements text, add it to string variables and compare them with "assert"
    // we will find elements and use them as we should for the registration process (mostly typing and clicking)

    @Test
    public void errorMessage(){
        Constants.regButton(driver).click();
        Registarion.logIn(driver).click();
        WebElement error1 = Registarion.userNameError(driver);
        String userError = error1.getText();
        WebElement error2 = Registarion.passwordError(driver);
        String password = error2.getText();
        Assert.assertEquals(userError, password);
        ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " error message");
    }


    // in the next test we going to check what is the text color
    // we will find elements and use them as we should for the registration process (mostly typing and clicking)

    @Test
    public void colorTest(){
        driver.navigate().to(SenderReceiverInfo.TEST_START_PAGE);
        driver.findElement(By.id(SenderReceiverInfo.SET_PRICE)).sendKeys("50");
        driver.findElement(By.className(SenderReceiverInfo.SELECT_BUTTON)).click();
        WebElement textColor = driver.findElement(By.xpath(SenderReceiverInfo.WHO_TO_SEND));
        String color = textColor.getCssValue("color");
        System.out.println(color);
        driver.findElement(By.className(SenderReceiverInfo.ELEMENT_FOR_COLOR_SCREENSHOT)).getText();
        ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " color test");
    }


    // in the next test we going to compare data between the left screen and the right screen with "assert"
    // we will find elements and use them as we should for the registration process (mostly typing and clicking)

    @Test
    public void copmareScreens(){
        driver.navigate().to(SenderReceiverInfo.TEST_START_PAGE);
        driver.findElement(By.id(SenderReceiverInfo.SET_PRICE)).sendKeys("50");
        driver.findElement(By.className(SenderReceiverInfo.SELECT_BUTTON)).click();
        driver.findElement(By.xpath(SenderReceiverInfo.SOME_ONE_ELSE)).click();
        driver.findElement(By.id(SenderReceiverInfo.GIFT_TO)).sendKeys("David");
        driver.findElement(By.id(SenderReceiverInfo.GIFT_FROM)).sendKeys("Doron");
        driver.findElement(By.xpath(SenderReceiverInfo.CLICK_EVENT)).click();
        driver.findElement(By.xpath(SenderReceiverInfo.SELECT_EVENT)).click();
        WebElement textArea = driver.findElement(By.xpath(SenderReceiverInfo.TEXT_AREA));

        // clearing the text area and write the text we want

        textArea.clear();
        textArea.sendKeys("text area test");
        String receiver = driver.findElement(By.className(SenderReceiverInfo.RECEIVER_LEFT_SCREEN)).getText();
        String sender = driver.findElement(By.xpath(SenderReceiverInfo.SENDER_LEFT_SCREEN)).getText();
        String greetingText = driver.findElement(By.className(SenderReceiverInfo.TEXT_LEFT_SCREEN)).getText();
        ScreenShots.takeScreenShot(Constants.SCREEN_SHOT_DIRECTORY + " copmare screens");
        Assert.assertEquals("David", receiver);
        Assert.assertEquals("Doron", sender);
        Assert.assertEquals("text area test", greetingText);
    }

//    @AfterClass
//    public static void afterClass() {
//        driver.quit();
//    }

}
