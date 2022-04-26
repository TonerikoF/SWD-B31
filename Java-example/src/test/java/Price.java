import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


//а) на главной странице и на странице товара совпадает текст названия товара
//б) на главной странице и на странице товара совпадают цены (обычная и акционная)
//в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
//г) акционная жирная и красная (можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)
// (цвета надо проверить на каждой странице независимо, при этом цвета на разных страницах могут не совпадать)
//д) акционная цена крупнее, чем обычная (это тоже надо проверить на каждой странице независимо)
public class Price extends TestBase {
    private Object ColorMake;

    @Test
    public void price(){
        openSite();
        WebElement generalItemRegularPrice = driver.findElement(By.cssSelector("#box-campaigns .regular-price"));
        String generalItemsName = driver.findElement(By.cssSelector("#box-campaigns .name")).getText();
        String compareGeneralItemRegularPrice = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getText();
        WebElement generalItemSalePrice = driver.findElement(By.cssSelector("#box-campaigns .campaign-price"));
        String compareGeneralItemSalePrice = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getText();
        //проверка серого
        ColorMake generalItemRegularPriceColor = new ColorMake(generalItemRegularPrice.getCssValue(("color")));
        Assertions.assertTrue(generalItemRegularPriceColor.ColorBlue == generalItemRegularPriceColor.ColorGreen
                && generalItemRegularPriceColor.ColorBlue == generalItemRegularPriceColor.ColorRed);
        // проверка "зачекнутый" шрифт
        String textThrough = generalItemRegularPrice.getCssValue(("text-decoration"));
        Assertions.assertTrue(textThrough.contains("line-through"));
        //проверка красного
        ColorMake generalItemSalePriceColor = new ColorMake(generalItemSalePrice.getCssValue(("color")));
        Assertions.assertTrue(generalItemSalePriceColor.ColorBlue == 0
                && generalItemSalePriceColor.ColorGreen == 0);
        // проверка "жирный" шрифт - не понимаю как в стронг найти bold, поэтому ищу в принципе по strong
        String textBold = generalItemSalePrice.getTagName();
        Assertions.assertTrue(textBold.contains("strong"));
        //проверка что скидочный ценник больше базового прайса
        Assertions.assertTrue(Double.valueOf(generalItemRegularPrice.getCssValue("font-size").replace("px",""))
                < Double.valueOf(generalItemSalePrice.getCssValue("font-size").replace("px","")));
        // переход на страницу товара
        driver.findElement(By.cssSelector("#box-campaigns a:first-child")).click();
        String pageItemsName = driver.findElement(By.cssSelector("h1")).getText();
        WebElement pageItemsRegularPrice = driver.findElement(By.cssSelector(".regular-price"));
        WebElement pageItemsItemSalePrice = driver.findElement(By.cssSelector(".campaign-price"));
        // сравнение заголовка и 2-х цен главная страниц/страница товара
        Assertions.assertTrue(generalItemsName.equals(pageItemsName));
        Assertions.assertTrue(compareGeneralItemRegularPrice.equals(pageItemsRegularPrice.getText()));
        Assertions.assertTrue(compareGeneralItemSalePrice.equals(pageItemsItemSalePrice.getText()));

        //проверка серого
        ColorMake pageItemsRegularPriceColor = new ColorMake(pageItemsRegularPrice.getCssValue(("color")));
        Assertions.assertTrue(pageItemsRegularPriceColor.ColorBlue == pageItemsRegularPriceColor.ColorGreen
                && pageItemsRegularPriceColor.ColorBlue == pageItemsRegularPriceColor.ColorRed);
        // проверка "зачекнутый" шрифт
        String pageTextThrough = pageItemsRegularPrice.getCssValue(("text-decoration"));
        Assertions.assertTrue(pageTextThrough.contains("line-through"));
        //проверка красного
        ColorMake pageItemsItemSalePriceColor = new ColorMake(pageItemsItemSalePrice.getCssValue(("color")));
        Assertions.assertTrue(pageItemsItemSalePriceColor.ColorBlue == 0
                && pageItemsItemSalePriceColor.ColorGreen == 0);
        // проверка "жирный" шрифт - не понимаю как в стронг найти bold, поэтому ищу в принципе по strong
        String pageTextBold = pageItemsItemSalePrice.getTagName();
        Assertions.assertTrue(pageTextBold.contains("strong"));
        //проверка что скидочный ценник больше базового прайса
        Assertions.assertTrue(Double.valueOf(pageItemsRegularPrice.getCssValue("font-size").replace("px",""))
                < Double.valueOf(pageItemsItemSalePrice.getCssValue("font-size").replace("px","")));
    }
}
