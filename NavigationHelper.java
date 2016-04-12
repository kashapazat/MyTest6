import org.openqa.selenium.By;


public class NavigationHelper extends HelperBase {

    private String baseUrl;

    public NavigationHelper(AppManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void goToPageQuestionsPage(){goToLinkByTextLink("Вопросы");}

    public void goToProfilePage(){goToLinkByTextLink("Профиль");}

    public void goToForumPage(){goToLinkByTextLink("Обсуждения");}

    public void goToUsersPage(){goToLinkByTextLink("Пользователи");}

    public void goToAboutPage(){goToLinkByTextLink("О нас");}

    public void goToAskPage(){goToLinkByTextLink("Задать Вопрос");    }

    public void goToTopicPage(String path){goToLinkByXpath(path);}

    public void goToLoginPage() {goToLinkByTextLink("Войти");}

    public void goToHomePage() {
        driver.get(baseUrl);
    }

    public void button(String xpathSelector) {driver.findElement(By.xpath(xpathSelector)).click();}

    public void goToLinkByTextLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public void goToLinkByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
}
