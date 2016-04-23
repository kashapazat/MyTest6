import org.openqa.selenium.By;
import org.w3c.css.sac.SACMediaList;

public class LoginHelper extends HelperBase {
    public LoginHelper(AppManager manager) {
        super(manager);
    }

    protected void login(AccountData accountData) {
        if (isLog()) {
            if (!isLog(accountData)){ manager.loginHelper.logout();}
        }
        fillTheField("username", accountData.getLogin());
        fillTheField("password", accountData.getPassword());
        manager.navigationHelper.button("//button[@type='submit']");
    }
    protected void logout() {

        if (isLog()){manager.driver.findElement(By.linkText("Выйти")).click();}
    }
    protected boolean isLog(){
        return manager.isElementPresent(By.linkText("Выйти"));
    }

    protected boolean isLog(AccountData accountData){
        if (!isLog()){
            return false;
        }
        String currentUrl = manager.driver.getCurrentUrl();
        manager.navigationHelper.goToProfilePage();
        manager.driver.get(currentUrl);
        String currentUserName = manager.driver.findElement(By.id("username")).getText();
        if (currentUserName.equals(accountData.getLogin())){
            return true;
        }
        return false;
    }
}