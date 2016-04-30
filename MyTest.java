import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class MyTest extends TestBase {
    @DataProvider
        public Object[][] messageFormsFromXml() {
                ArrayList<MessageForm> result = new ArrayList<>();
                try {
                        File fxmlFile = new File("Message.xml");
                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
                        Document document = documentBuilder.parse(fxmlFile);
                        document.getDocumentElement().normalize();
                        NodeList nList = document.getElementsByTagName("messages");
                        for (int i = 0; i < nList.getLength(); i++) {
                               Node node = nList.item(i);
                                Element element = (Element) node;
                                result.add((MessageForm) new MessageForm(element.getElementsByTagName("value").item(0).getTextContent()));
                            }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                Object[][] obj1 = (Object[][]) result.toArray();
                return obj1;
            }

                @Test(dataProvider = "messageFormsFromXml")
        public void openHomeTest(String value) {
                    app.navigationHelper.goToHomePage();
                System.out.println(value);
                MessageForm message1 = new MessageForm(value);
        app.messageHelper.askQuestion(message1);
    }

    @Test(dataProvider = "messageFormsFromXml")
        public void commentYourTopicTest(String value) {
        app.navigationHelper.goToForumPage();
        app.navigationHelper.goToLinkByXpath("http://soft.softodrom.ru/");

        System.out.println(value);
        MessageForm message2 = new MessageForm(value);
        app.messageHelper.sendComment(message2);
    }

    @Test
    @Test(dataProvider = "messageFormsFromXml")
        public void deleteCommentTest(String value) {
        app.navigationHelper.goToAboutPage();
        app.navigationHelper.goToForumPage();
        MessageForm message3 = new MessageForm(value);
        app.messageHelper.sendComment(message3);
        app.messageHelper.deleteContent("span.glyphicon.glyphicon-trash");
    }

    @Test
    public void logout(){
        app.loginHelper.logout();
    }
    }




