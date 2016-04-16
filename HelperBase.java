import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;
    protected AppManager manager;

    public HelperBase(AppManager manager) {
        this.manager = manager;
        driver = manager.driver;
    }


    public void fillTheFieldByName(String field, String value) {
        driver.findElement(By.name(field)).clear();
        driver.findElement(By.name(field)).sendKeys(value);
    }

    public void fillTheField (String field, String value) {
        driver.findElement(By.id(field)).clear();
        driver.findElement(By.id(field)).sendKeys(value);
    }

    public void clickByCssSelector(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }
}