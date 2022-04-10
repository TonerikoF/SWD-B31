import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTest extends HW_3 {
    @Test
    public void smokeTest() {
        login();
        int countLi = driver.findElements(By.cssSelector("#box-apps-menu > li")).size();
        for (int i = 1; i <= countLi; i++) {
            String clicElement = "#box-apps-menu > li:nth-child(" + i + ")";
            driver.findElement(By.cssSelector(clicElement)).click();
            int count = driver.findElements(By.cssSelector("h1")).size();
            if (count > 0) {
                List<WebElement> countBotElement = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span"));
                int countBottElement = countBotElement.size();
                for (int j = 1; j < countBottElement; j++) {
                    countBotElement = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span"));
                    countBotElement.get(j).click();
                }
            }
        }
        outSession();
    }
}

