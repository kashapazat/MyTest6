import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MyTest extends TestBase {
    @Test
    public void testMy() throws Exception {
        app.navigationHelper.goToHomePage();

        MessageForm message1 = new MessageForm("фотошоп");

        app.messageHelper.askQuestion(message1);

        app.navigationHelper.goToForumPage();

        app.navigationHelper.goToLinkByXpath("http://soft.softodrom.ru/");

        MessageForm message2 = new MessageForm("Windows Cleaner");
        app.messageHelper.sendComment(message2);

        app.navigationHelper.goToAboutPage();

        app.navigationHelper.goToForumPage();

        app.navigationHelper.goToLinkByXpath("http://soft.softodrom.ru/%D0%9F%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D1%8B/?ras=13");

        MessageForm message3 = new MessageForm("message1");
        app.messageHelper.sendComment(message3);

        app.navigationHelper.goToProfilePage();

        app.loginHelper.logout();

    }


}