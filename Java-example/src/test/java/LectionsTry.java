import jdk.jfr.Timespan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LectionsTry {
    /* public WebDriver driver;
    public WebDriverWait wait;

    @Test
    public void lectionsTry (){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://pagination.js.org/index.html");
        WebElement demo1 = driver.findElement(By.cssSelector("#demo1"));
        List<WebElement> items = demo1.findElements(By.cssSelector(".data-container ul li"));
        List<WebElement> pagination = demo1.findElements(By.cssSelector(".paginationjs-pages ul li"));

        pagination.get(2).click();
        wait.until(ExpectedConditions.stalenessOf(items.get(0)));
        items = demo1.findElements(By.cssSelector(".data-container ul li"));
        Assertions.assertTrue(items.get(0).getText().equals("11"));
    private WebDriver driver;
    private WebDriverWait wait;
    @Test

    public void myFirstTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
        String title = driver.getTitle();
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void stop() {
    }*/
}

