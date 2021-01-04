package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import sun.security.krb5.Config;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AmazonTest {
    @Test
    public void test() {


//    amazon' a gidelim
        Driver.getDriver().get(ConfigReader.getProperty("page_url"));
//
//    Linki Config Reader dan alalım
//    Başlığın Elektronik içerip içermediğini kontrol edelim
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("aranan_title")));
//    All Categories ' e gidelim

//    "Toys & Games" ı seçelim
        AmazonPage amazonPage=new AmazonPage();
        Select select=new Select(amazonPage.searchDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("categori"));
//    Arama kelimesini config reader dan alalım
//    Arama kutusuna toy story yazdıralım-- Config reader dan alalım
        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("aranan_deger")+ Keys.ENTER);
//    İlk sayfadaki bütün fiyatları listeleyip yazdıralım en düşük ve en yüksek fiyatı bulalım
        List<Double> fiyatlar=new ArrayList<>();

        for (int i=0;i<amazonPage.fiyatlistesitamkisim.size()-1; i++){
            if(!amazonPage.fiyatlistesitamkisim.get(i).getText().isEmpty()){
                fiyatlar.add(Double.valueOf(amazonPage.fiyatlistesitamkisim.get(i).getText()+"."+amazonPage.fiyatlistesiondalikkisim.get(i).getText()));
            }

        }
        Collections.sort(fiyatlar);
        System.out.println(fiyatlar);
        System.out.println("maksimum fiyat= "+fiyatlar.get(fiyatlar.size()-1));
        System.out.println("minimum fiyat= "+fiyatlar.get(0));

//    Herhangi bir  ürünü önce tıklayıp sonra sepete ekleyelim.
        amazonPage.urun.click();
        amazonPage.sepeteEkle.click();


//    Sepete gidip seçimi yapıp yapamadığımızı assert edelim.
        ReusableMethods.waitFor(5);
        amazonPage.cartbutonu.click();
        ReusableMethods.waitFor(5);
        Assert.assertTrue(amazonPage.sepettekiUrun.isDisplayed());



        Driver.closeDriver();
    }

}
