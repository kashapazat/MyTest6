import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by Азат on 12.04.2016.
 */
public class AuthBase extends TestBase {
    @BeforeClass(alwaysRun = true)
    protected void setUpAuth() throws Exception {
        app.navigationHelper.goToLoginPage();
        app.loginHelper.login(new AccountData(app.baseConfig.getLogin(), app.baseConfig.getPassword()));
    }
}