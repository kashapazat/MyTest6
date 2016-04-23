import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.Random;

public class TestBase {
    protected AppManager app;
    protected StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    protected void setUp() throws Exception {
        app = new AppManager();
        app.driver.manage().window().maximize();
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.navigationHelper.goToHomePage();
        app.navigationHelper.goToLoginPage();
        app.loginHelper.login(new AccountData("itisazat", "g9wxzxw6"));
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() throws Exception {
        app.Stop();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public String generateRandomString(int size){
        StringBuilder result = new StringBuilder();
        String symbols = "qwertyuioplkjhgfdsazxcvbnm";
        Random random = new Random();
        for (int i=0;i< size;i++){
            result.append(symbols.charAt(random.nextInt(symbols.length())));
        }
        return  result.toString();
    }
}