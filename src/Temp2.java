import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Temp2 {

        public static WebElement element = null;

        static WebElement pressFive(WebDriver driver) {
            return driver.findElement(By.id(HomePage.PRICE));
        }

}
