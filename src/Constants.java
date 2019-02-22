import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Constants {

    public static final String CHROM_DRIVER = "C:\\selenium\\chromedriver.exe";


    public static final String FIREFOX_DRIVER = "C:\\selenium\\geckodriver.exe";


    public static final String SCREEN_SHOT_DIRECTORY = "d:\\docs\\screen shots\\";


    public static final String REG_BUTTON = "seperator-link";
    static WebElement regButton(WebDriver driver) {
        return driver.findElement(By.className(REG_BUTTON));
    }

    public static final String REG_LINK = "text-btn";
    static WebElement regLink(WebDriver driver) {
        return driver.findElement(By.className(REG_LINK));
    }

    public static final String URL_FILE = "E:\\JavaClass\\files for tests\\URL file.txt";

    static WebElement pressFive(WebDriver driver) {
        return driver.findElement(By.id(HomePage.PRICE));
    }

}
