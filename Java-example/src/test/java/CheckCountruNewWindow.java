import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;

public class CheckCountruNewWindow extends TestBase{
    @Test
    public void checkCountruNewWindow(){
        //1) зайти в админку
        loginAdmin();
        //2) открыть пункт меню Countries (или страницу http://localhost/litecart/admin/?app=countries&doc=countries)
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        //3) открыть на редактирование какую-нибудь страну или начать создание новой
        driver.findElement(By.className("button")).click();
        //4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
        //требуется именно кликнуть по ссылке, чтобы она открылась в новом окне, потом переключиться в новое окно, закрыть его, вернуться обратно,
        //и повторить эти действия для всех таких ссылок.
        List<WebElement> linkList = driver.findElements(By.cssSelector("[target='_blank']"));
        for (int i = 0; i < linkList.size(); i++) {
            Set<String> windows = driver.getWindowHandles();
            String currentWindows = driver.getWindowHandle();
            linkList.get(i).click();
            String newWindow = wait.until(otherWindow(windows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(currentWindows);
            }
        outSession();
        }
    }
