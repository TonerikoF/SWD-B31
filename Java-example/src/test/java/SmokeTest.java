import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SmokeTest extends TestBase {
    @Test
    public void smokeTest() {
        loginAdmin();
        List<WebElement> count1Element = driver.findElements(By.cssSelector("#box-apps-menu > li"));
        for (int i = 0; i <= count1Element.size() - 1; i++) {
            count1Element = driver.findElements(By.cssSelector("#box-apps-menu > li"));
            count1Element.get(i).click();
            Assertions.assertTrue(isElementPresent(driver, By.cssSelector("#content h1")));
            if (isElementPresent(driver, By.cssSelector(".docs"))) {
                List<WebElement> count2Element = driver.findElements(By.cssSelector("li .docs span"));
                for (int j = 0; j <= count2Element.size()-1; j++) {
                    count2Element = driver.findElements(By.cssSelector("li .docs span"));
                    count2Element.get(j).click();
                    Assertions.assertTrue(isElementPresent(driver, By.cssSelector("#content h1")));
                }
            }
        }
        outSession();
    }
}






