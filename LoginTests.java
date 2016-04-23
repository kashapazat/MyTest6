import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Азат on 12.04.2016.
 */
public class LoginTests extends TestBase{
    @Test
    public void LoginWithValidData(){

        AccountData accountData = new AccountData(app.baseConfig.getLogin(),app.baseConfig.getPassword());
        app.loginHelper.logout();
        app.navigationHelper.goToLoginPage();
        app.loginHelper.login(accountData);

        Assert.assertEquals(app.loginHelper.isLog(accountData),true);
    }
}