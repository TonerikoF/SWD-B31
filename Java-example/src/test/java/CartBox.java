//Сделайте сценарий для добавления товаров в корзину и удаления товаров из корзины.
        //1) открыть главную страницу
        //2) открыть первый товар из списка
        //2) добавить его в корзину (при этом может случайно добавиться товар, который там уже есть, ничего страшного)
        //3) подождать, пока счётчик товаров в корзине обновится
        //4) вернуться на главную страницу, повторить предыдущие шаги ещё два раза, чтобы в общей сложности в корзине было 3 единицы товара
        //5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
        //6) удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CartBox extends TestBase{
    @Test
    public void cartBox(){
        openSite();
        WebElement cart = driver.findElement(By.cssSelector("span.quantity"));
        String countCart = cart.getAttribute(("innerText"));
        for (int i =Integer.valueOf(countCart); i < 3; i++) {
            driver.findElement(By.cssSelector(".product")).click();
            if (isElementPresent(driver,(By.name("options[Size]")))) {
                driver.findElement(By.cssSelector("[name='options[Size]'] :nth-child(2)")).click();
            }
            driver.findElement(By.name("add_cart_product")).click();
            cart = driver.findElement(By.cssSelector("span.quantity"));
            wait.until(ExpectedConditions.attributeToBe(cart, "innerText", Integer.toString(i+1))); //не понимаю, почему не работае
            back();
        }
        driver.findElement(By.cssSelector("#cart .link")).click();
        List <WebElement> remove = driver.findElements(By.name("remove_cart_item"));
        while(remove.size() != 0){
            WebElement removeButton = driver.findElement(By.name("remove_cart_item"));
            removeButton.click();
            wait.until(ExpectedConditions.stalenessOf(removeButton));
            remove = driver.findElements(By.name("remove_cart_item"));
        }
    }
}
