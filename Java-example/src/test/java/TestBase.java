import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;


    public void loginAdmin () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
    public void openSite() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost/litecart");
    }

    public void outSession(){
        driver.quit();
        driver = null;
    }

    boolean isElementPresent(WebDriver driver, By locator) {

        return driver.findElements(locator).size() > 0;
    }
    public void back () {
        driver.navigate().back();
    }

}
