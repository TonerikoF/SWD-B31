import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestItems extends Loggin {
    @Test
    public void items() {
        loginSite();

        List<WebElement> serchItem = driver.findElements(By.cssSelector(".product"));
        for (int i = 0; i < serchItem.size(); i++) {
            WebElement duck = serchItem.get(i);
            int countStiker = duck.findElements(By.cssSelector("div.sticker")).size();
            if (countStiker != 1) {throw new AssertionError();
            }
        }// можно как-то вызвать sout? что бы понять в правильную ли утку я захожу, мне пока не очевидно(
        outSession();
    }
}

