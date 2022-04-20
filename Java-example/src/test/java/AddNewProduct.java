import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Сделайте сценарий для добавления нового товара (продукта) в учебном приложении litecart (в админке).

//Для добавления товара нужно открыть меню Catalog, в правом верхнем углу нажать кнопку "Add New Product",
// заполнить поля с информацией о товаре и сохранить.
//Достаточно заполнить только информацию на вкладках General, Information и Prices.
// Скидки (Campains) на вкладке Prices можно не добавлять.

//Переключение между вкладками происходит не мгновенно, поэтому после переключения можно сделать небольшую паузу
// (о том, как делать более правильные ожидания, будет рассказано в следующих занятиях).

//Картинку с изображением товара нужно уложить в репозиторий вместе с кодом.
// При этом указывать в коде полный абсолютный путь к файлу плохо, на другой машине работать не будет.
// Надо средствами языка программирования преобразовать относительный путь в абсолютный.
public class AddNewProduct extends TestBase {

    @Test

    public void addNewProduct(){
        loginAdmin();
        driver.findElement(By.cssSelector("#box-apps-menu li:nth-child(2)")).click();
        driver.findElement(By.linkText("Add New Product")).click();
        driver.findElement(By.name("name[en]")).sendKeys("future duck");
        driver.findElement(By.name("code")).sendKeys("2313213");
        driver.findElement(By.cssSelector("[value='1-3']")).click();
        driver.findElement(By.name("quantity")).sendKeys(Keys.RIGHT+"12");
        File file = new File("src/img/Doc-Brown-Back-to-the-Future-TUBBZ.jpg");
        driver.findElement(By.name("new_images[]")).sendKeys(file.getAbsolutePath());

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");

        String dateFrom = dateTimeFormatter.format(localDate);
        String dateTo = dateTimeFormatter.format(localDate.plusYears(1));
        driver.findElement(By.name("date_valid_from")).sendKeys(dateFrom);
        driver.findElement(By.name("date_valid_to")).sendKeys(dateTo);

        driver.findElement(By.linkText("Information")).click();
        Select manufacture = new Select(driver.findElement(By.name("manufacturer_id")));
        manufacture.selectByValue("1");
        driver.findElement(By.name("keywords")).sendKeys("future duck");
        driver.findElement(By.name("short_description[en]")).sendKeys("lorem about future duck");
        driver.findElement(By.name("description[en]")).sendKeys("long lorem about future duck");
        driver.findElement(By.name("head_title[en]")).sendKeys("Head about future duck");
        driver.findElement(By.name("meta_description[en]")).sendKeys("tags about future duck");

        driver.findElement(By.linkText("Prices")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("5");
        Select price = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        price.selectByValue("EUR");
        driver.findElement(By.name("prices[USD]")).sendKeys("7");
        driver.findElement(By.name("prices[EUR]")).sendKeys("5");

        driver.findElement(By.name("save")).click();
    }
}
