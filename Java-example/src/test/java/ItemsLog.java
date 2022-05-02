import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemsLog extends TestBase{
    @Test
    public void itemsLog() {
        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> items = driver.findElements(By.cssSelector("a[href*='product_id']"));
        for (int i = 0; i < items.size(); i += 2) {
            items = driver.findElements(By.cssSelector("a[href*='product_id']"));
            items.get(i).click();
            driver.navigate().back();
            //последовательно открывать страницы товаров и проверять, не появляются ли в логе браузера сообщения (любого уровня)
            driver.manage().logs().get("browser").forEach(l -> {
                System.out.println(l);
                Assertions.assertTrue(l.equals(""));
            });
        }
        outSession();
    }
}
