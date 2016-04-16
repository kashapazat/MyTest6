import org.openqa.selenium.By;

public class MessageHelper extends HelperBase {

    public MessageHelper(AppManager manager) {
        super(manager);
    }

    protected void askQuestion(MessageForm messageForm) {
        fillTheFieldByName("theme",messageForm.getValue());
        manager.navigationHelper.button("//button[@type='submit']");
    }

    protected void sendComment(MessageForm messageForm){
        fillTheFieldByName("content",messageForm.getValue());
        manager.navigationHelper.button("//button[@type='submit']");
    }

    protected void deleteContent(String cssSelector){
        clickByCssSelector(cssSelector);
    }

}