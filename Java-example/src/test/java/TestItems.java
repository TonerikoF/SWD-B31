import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestItems extends TestBase {
    @Test
    public void items() {
        loginSite();

        List<WebElement> serchItem = driver.findElements(By.cssSelector(".product"));
        for (int i = 0; i < serchItem.size(); i++) {
            WebElement duck = serchItem.get(i);
            int countStiker = duck.findElements(By.cssSelector("div.sticker")).size();
            if (countStiker != 1) {throw new AssertionError();
            }
            /*System.out.print(duck.getText());
        for (WebElement try2:serchItem) {
            System.out.print(try2.getText());*/
            
        }outSession();
    }

}


