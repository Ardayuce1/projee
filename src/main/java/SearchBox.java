import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends Basepage{

    By searchBoxLocater = By.id("twotabsearchtextbox");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocater, text);
        click(searchBoxLocater);

    }
}
