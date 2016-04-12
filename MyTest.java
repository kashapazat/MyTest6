import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MyTest extends TestBase {
    @Test
    public void testMy() throws Exception {
        app.navigationHelper.goToAskPage();

        MessageForm message1 = new MessageForm("me need help for my problem");

        app.messageHelper.askQuestion(message1);

        app.navigationHelper.goToPageQuestionsPage();

        app.messageHelper.deleteContent("span.glyphicon-class");

        app.navigationHelper.goToForumPage();

        app.navigationHelper.goToLinkByXpath("//div[3]/div/div[2]/a/div/span[2]");

        MessageForm message2 = new MessageForm("1");
        app.messageHelper.sendComment(message2);

        app.navigationHelper.goToAboutPage();

        app.navigationHelper.goToUsersPage();

        app.navigationHelper.goToForumPage();

        app.navigationHelper.goToLinkByXpath("//div[2]/div/div[2]/a/div/span[2]");

        MessageForm message3 = new MessageForm("help me");
        app.messageHelper.sendComment(message3);

        app.messageHelper.deleteContent("span.glyphicon.glyphicon-trash");

        app.navigationHelper.goToProfilePage();

        app.loginHelper.logout();

    }


}