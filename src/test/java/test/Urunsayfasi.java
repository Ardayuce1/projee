package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Urunsayfasi extends Basepage {
    By shippingOptionLocater = By .id("id=\"category-breadcrumb\"");


    public Urunsayfasi(WebDriver driver){
        super(driver);
    }
    public boolean isOnUrunsayfasi() {
        boolean isDisplayed;
        return isDisplayed(shippingOptionLocater);

    }

    private boolean isDisplayed(By shippingOptionLocater) {
    }

    public void urunusec(int i) {
    }
}
