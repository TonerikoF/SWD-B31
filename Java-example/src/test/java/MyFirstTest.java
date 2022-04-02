import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyFirstTest {

    public WebDriver driver;
    public WebDriverWait wait;
    @Test
    public void myFirstTest(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();

        driver.quit();
        driver = null;
    }
}
