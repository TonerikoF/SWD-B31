import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public WebDriver driver;

    public void loginAdmin () {
        driver = new ChromeDriver();

        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
    public void loginSite() {
        driver = new ChromeDriver();

        driver.get("http://localhost/litecart");
    }

    public void outSession(){
        driver.quit();
        driver = null;
    }
    boolean isElementPresent(WebDriver driver, By locator) {
            return driver.findElements(locator).size() > 0;
        }

}
