package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class test2 {

    Anasayfa anasayfa;
    Urunsayfasi urunsayfasi;
    UrunDetaySayfasi urunDetaySayfasi;

    WebDriver driver;

    @Test

    public void TestHome(){

        WebElement girisbtn= driver.findElement(By.className("giris yap"));
        girisbtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement mailbox= driver.findElement(By.id("eposta"));
        mailbox.click();
        mailbox.sendKeys("eposta adresiniz");

        WebElement password = driver.findElement(By.id("şifre"));
        password.click();
        password.sendKeys("şifreniz");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.id("Giriş yap butonu")).click();
    }

    @Test
    public void urunu_ara(){
        anasayfa.searchbox().search("Pantalon");
        Assertions.assertTrue(urunsayfasi.isOnUrunsayfasi(),
               "Ürün sayfasında yok" );
    }

    @Test
    public void urune_tikla(){
        urunsayfasi.urunusec(1);
        Assertions.assertTrue(urunDetaySayfasi.isOnUrunDetaySayfasi,
                "Ürün detay sayfası açılmadı" );
    }
    @Test
    public void urunu_sepete_ekle(){
        urunDetaySayfasi.addToSepet();
        Assertions.assertTrue(anasayfa.isOnUrunKontrol,
                "Ürün sayısı artmadı");
    }
    @Test
            public void urunu_sepetten_sil() {
        WebElement fiyatsepeti = driver.findElement(By.className("fiyat"));
        String urunFiyat2 = fiyatsepeti.getText();
        String urunfiyat= fiyatsepeti.getText();
        if (urunfiyat.compareTo(urunFiyat2) > 0) {

            WebElement miktarsepeti = driver.findElement(By.id("miktar_W17843Z1"));
            miktarsepeti.click();
            miktarsepeti.clear();
            miktarsepeti.sendKeys("2");
            driver.findElement(By.className("döndür")).click();
        }
    }
    @Test
    public void sepetteki_urunlerin_bosaltilmasi(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("ürünü kaldır")).click();
    }

    @AfterAll
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }

}
