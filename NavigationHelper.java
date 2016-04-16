import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    private String baseUrl;

    public NavigationHelper(AppManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void goToGamesPage(){goToLinkByTextLink("Игры");}

    public void goToProfilePage(){goToLinkByTextLink("Личная страница");}

    public void goToSoftwarePage(){goToLinkByTextLink("Программы");}

    public void goToNewsPage(){goToLinkByTextLink("Новости");}

    public void goToAboutPage(){goToLinkByTextLink("О проекте");}

    public void goToForumPage(){goToLinkByTextLink("Наш форум");    }

    public void goToTopicPage(String path){goToLinkByXpath(path);}

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