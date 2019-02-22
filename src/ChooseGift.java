import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseGift {

    public static final String URL_TEST = "https://buyme.co.il/search?budget=2&category=16&query=%D7%91%D7%9C%D7%94%20%D7%91%D7%A2%D7%9E%D7%A7&region=9";

    public static final String BELA_REST_LINK = "thumbnail";
    static WebElement belaRestLink(WebDriver driver) {
        return driver.findElement(By.className(BELA_REST_LINK));
    }


}
