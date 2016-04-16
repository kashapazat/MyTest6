import org.openqa.selenium.By;

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
        manager.driver.findElement(By.linkText("Выход")).click();
    }
}