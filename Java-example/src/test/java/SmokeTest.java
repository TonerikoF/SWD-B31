import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SmokeTest extends Loggin {
    @Test
    public void smokeTest() {
        loginAdmin();
        List<WebElement> count1Element = driver.findElements(By.cssSelector("#box-apps-menu > li"));
        for (int i = 0; i <= count1Element.size()-1; i++) {
            count1Element = driver.findElements(By.cssSelector("#box-apps-menu > li"));
            count1Element.get(i).click();
            int count = driver.findElements(By.cssSelector("h1")).size();
            if (count > 0) {
                List<WebElement> count2Element = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span"));
                for (int j = 1; j < count2Element.size(); j++) {
                    count2Element = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span"));
                    count2Element.get(j).click();
                    int count3 = driver.findElements(By.cssSelector("[class=docs] h1")).size(); // тут же будет h2 скорее всего?
                    if (count3 > 0) {
                        List<WebElement> count3Element = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span"));//(другой какой-то локатор сооветсвии с заголовком 3 уровня
                        for (int k = 1; k < count3Element.size(); k++) {
                            count3Element = driver.findElements(By.cssSelector("#box-apps-menu > li#app- [class=docs] span"));//(другой какой-то локатор сооветсвии с заголовком 3 уровня
                            count3Element.get(k).click();
                        }
                    }
                }
            }
        }
        outSession();
    }
}

