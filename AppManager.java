import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AppManager {
    private String baseUrl;
    protected WebDriver driver;
    protected LoginHelper loginHelper;
    protected NavigationHelper navigationHelper;
    protected MessageHelper messageHelper;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected boolean acceptNextAlert = true;

    public AppManager() {
        driver = new FirefoxDriver();
        baseUrl = "http://www.softodrom.ru/";
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
        messageHelper = new MessageHelper(this);
    }


    @AfterClass(alwaysRun = true)
    protected void Stop() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public void setLoginHelper(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void setNavigationHelper(NavigationHelper navigationHelper) {
        this.navigationHelper = navigationHelper;
    }

    public MessageHelper getMessageHelper() {
        return messageHelper;
    }

    public void setMessageHelper(MessageHelper messageHelper) {
        this.messageHelper = messageHelper;
    }
}