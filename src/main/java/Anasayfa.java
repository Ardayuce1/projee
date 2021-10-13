import org.openqa.selenium.WebDriver;

public class Anasayfa extends Basepage {


    SearchBox searchBox;
    public Anasayfa(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    public SearchBox searchBox(){

        return this.searchBox;
    }
}
