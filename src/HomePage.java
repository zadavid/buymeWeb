import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public static final String PRICE = "ember662_chosen";
    static WebElement price(WebDriver driver) {
        return driver.findElement(By.id(PRICE));
    }

    public static final String PRICE_RANGE = "//*[@id=\"ember662_chosen\"]/div/ul/li[3]";
    static WebElement priceRange(WebDriver driver) {
        return driver.findElement(By.xpath(HomePage.PRICE_RANGE));
    }

    public static final String AREA = "ember677_chosen";
    static WebElement area(WebDriver driver) {
        return driver.findElement(By.id(HomePage.AREA));
    }

    public static final String AREA_SELECT = "//*[@id=\"ember677_chosen\"]/div/ul/li[4]";
    static WebElement areaSelect(WebDriver driver) {
        return driver.findElement(By.xpath(HomePage.AREA_SELECT));
    }

    public static final String GIFT_CATEGORY = "ember686_chosen";
    static WebElement giftCategory(WebDriver driver) {
        return driver.findElement(By.id(HomePage.GIFT_CATEGORY));
    }

    public static final String GIFT_SELECT = "//*[@id=\"ember686_chosen\"]/div/ul/li[3]";
    static WebElement giftSelect(WebDriver driver) {
        return driver.findElement(By.xpath(HomePage.GIFT_SELECT));
    }

    public static final String SEARCH_BAR = "ember718";
    static WebElement searchBar(WebDriver driver) {
        return driver.findElement(By.id(HomePage.SEARCH_BAR));
    }

    public static final String SEARCH_BUTTON = "ember721";
    static WebElement searchButton(WebDriver driver) {
        return driver.findElement(By.id(HomePage.SEARCH_BUTTON));
    }


}
