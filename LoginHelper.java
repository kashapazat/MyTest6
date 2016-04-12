import org.openqa.selenium.By;

/**
 * Created by Rail on 11.04.2016.
 */
public class LoginHelper extends HelperBase {
    public LoginHelper(AppManager manager) {
        super(manager);
    }

    protected void login(AccountData accountData) {
        fillTheField("username",accountData.getLogin());
        fillTheField("password",accountData.getPassword());
        manager.navigationHelper.button("//button[@type='submit']");
    }
    protected void logout() {
        manager.driver.findElement(By.linkText("Выйти")).click();
    }
}
