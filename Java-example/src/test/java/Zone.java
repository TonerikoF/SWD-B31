import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Zone extends TestBase {
    @Test
    public void zone() {
        loginAdmin();
        driver.findElement(By.cssSelector("[href*='zone']")).click();
        List<WebElement> zones = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
        for (int i = 0; i < zones.size(); i++) {
            zones = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
            zones.get(i).click();
            List<WebElement> zonesInCountry = driver.findElements(By.cssSelector("[name*=zone_code] >[selected=selected]"));
            for (int j = 0; j <= zonesInCountry.size() - 2; j++) {
                String compareZone = zonesInCountry.get(j).getText();
                String compareZone2 = zonesInCountry.get(j + 1).getText();
                //System.out.print(compareZone);
                //System.out.print(compareZone2);
                //System.out.println();
                if (i < zonesInCountry.size()) {
                    Assertions.assertTrue(compareZone.compareTo(compareZone2) < 0);
                }
            }
            driver.findElement(By.cssSelector("[href*='zone']")).click();
        }
        outSession();
    }
}

