import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SenderReceiverInfo {

    public static final String TEST_START_PAGE = "https://buyme.co.il/supplier/371306";

    public static final String SET_PRICE = "input-cash";
    static WebElement setPrice(WebDriver driver) {
        return driver.findElement(By.className(SET_PRICE));
    }

    public static final String SELECT_BUTTON = "btn-wrapper";
    static WebElement selectButton(WebDriver driver) {
        return driver.findElement(By.className(SELECT_BUTTON));
    }

    public static final String SOME_ONE_ELSE = "//*[@id=\"ember975\"]/label[1]/span[1]";
    static WebElement someOneElse(WebDriver driver) {
        return driver.findElement(By.xpath(SOME_ONE_ELSE));
    }

    public static final String GIFT_TO = "ember1008";
    static WebElement giftTo(WebDriver driver) {
        return driver.findElement(By.id(GIFT_TO));
    }

    public static final String GIFT_FROM = "ember1010";
    static WebElement giftFrom(WebDriver driver) {
        return driver.findElement(By.id(GIFT_FROM));
    }

    public static final String CLICK_EVENT = "//*[@id=\"ember1012_chosen\"]/a/span";
    static WebElement clickEvent(WebDriver driver) {
        return driver.findElement(By.xpath(CLICK_EVENT));
    }

    public static final String SELECT_EVENT = "//*[@id=\"ember1012_chosen\"]/div/ul";
    static WebElement selectEvent(WebDriver driver) {
        return driver.findElement(By.xpath(SELECT_EVENT));
    }

    public static final String TEXT_AREA = "//*[@id=\"ember1026\"]/textarea";
    static WebElement textArea(WebDriver driver) {
        return driver.findElement(By.xpath(TEXT_AREA));
    }

    public static final String UPLOAD_PIC = "ember1035";
    static WebElement uploadPic(WebDriver driver) {
        return driver.findElement(By.id(UPLOAD_PIC));
    }

    public static final String PICTURE = "E:\\JavaClass\\Project 2\\projectFiles\\upload picture - java table.png";

    public static final String SEND_NOW = "send-now";
    static WebElement sendItNow(WebDriver driver) {
        return driver.findElement(By.className(SEND_NOW));
    }

    public static final String SEND_LATER = "//*[@id=\"ember968\"]/div[3]/div/div[1]/label[2]";
    static WebElement sendItLater(WebDriver driver) {
        return driver.findElement(By.xpath(SEND_LATER));
    }

    public static final String SEND_BY_MAIL = "icon-envelope";
    static WebElement sendByMail(WebDriver driver) {
        return driver.findElement(By.className(SEND_BY_MAIL));
    }

    public static final String TYPE_MAIL = "input-mail";
    static WebElement typeMail(WebDriver driver) {
        return driver.findElement(By.className(TYPE_MAIL));
    }

    public static final String SAVE_MAIL_BUTTON = "btn-save";
    static WebElement saveMailButton(WebDriver driver) {
        return driver.findElement(By.className(SAVE_MAIL_BUTTON));
    }

    public static final String PAY_BUTTON = "btn-theme";
    static WebElement payButton(WebDriver driver) {
        return driver.findElement(By.className(PAY_BUTTON));
    }



    // extras

    public static final String WHO_TO_SEND = "//*[@id=\"ember578\"]/div/div[2]/div[1]/ul[1]/li[2]/div[2]/span";
    public static final String RECEIVER_LEFT_SCREEN = "name";
    public static final String SENDER_LEFT_SCREEN = "//*[@id=\"ember990\"]/div/div[2]/div[3]/span[2]";
    public static final String TEXT_LEFT_SCREEN = "cut-greeting";
    public static final String ELEMENT_FOR_COLOR_SCREENSHOT = "page-title--padded";
}
