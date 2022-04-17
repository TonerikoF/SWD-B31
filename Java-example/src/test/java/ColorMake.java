import org.openqa.selenium.support.Color;
public class ColorMake {
    int ColorBlue;
    int ColorGreen;
    int ColorRed;
    String locatorCss;
    String textStyle;

    public ColorMake(String locatorCss) {
        this.locatorCss = locatorCss;
        this.ColorBlue = Color.fromString(locatorCss).getColor().getBlue();
        this.ColorGreen = Color.fromString(locatorCss).getColor().getGreen();
        this.ColorRed = Color.fromString(locatorCss).getColor().getRed();
    }
    public int getColorBlue(){
        return ColorBlue;
    }
    public int getColorGreen(){
        return ColorGreen;
    }
    public int getColorRed(){
        return ColorRed;
    }
}
