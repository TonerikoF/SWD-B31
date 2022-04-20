import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewUser extends TestBase {
    @Test
    public void newUser(){
        String email = "user" + (int)(Math.random()*100) + "@gmail.com";
        String phone = "095-1265";
        String password = "test12345";
        openSite();
        driver.findElement(By.linkText("New customers click here")).click();
        driver.findElement(By.name("firstname")).sendKeys("User");
        driver.findElement(By.name("lastname")).sendKeys("Userov");
        driver.findElement(By.name("address1")).sendKeys("USA, Texas");
        driver.findElement(By.name("postcode")).sendKeys("00299");
        driver.findElement(By.name("city")).sendKeys("Ostin");
        Select dropdownField = new Select (driver.findElement(By.name("country_code")));
        dropdownField.selectByValue("US");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.findElement(By.linkText("Logout")).click();
        outSession();
    }
}
