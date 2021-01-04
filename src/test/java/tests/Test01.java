package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Test01Locater;
import utilities.ConfigReader;
import utilities.Driver;

public class Test01 {
    @Test
    public void test01(){

//        1-  https://www.amazon.com adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("page_url"));

        Test01Locater test01Locater=new Test01Locater();

//        2-  dropDowndan "computers" secenegini secin
      Select select=new Select(test01Locater.searchDropdown);
      select.selectByVisibleText(ConfigReader.getProperty("visible_text"));


//        3-  Arama kutusuna "Asus" yazin

        test01Locater.searchBox.sendKeys(ConfigReader.getProperty("arama_Kutusu" )+Keys.ENTER);

//        4-  arama sonucununun goruntulendigini dogrulayin
        boolean gorunuyorMu=test01Locater.sonucYazisi.isDisplayed();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(gorunuyorMu);

//        5-  Listelenen 2. elemanı ekrana yazdırın
        System.out.println(test01Locater.arananElement.getText());

//        6-  2.elemana ait yazının "ASUS" içerdiğini test edin
        softAssert.assertTrue(test01Locater.arananElement.getText().contains(ConfigReader.getProperty("aranan_Deger")));
   Driver.closeDriver();
   softAssert.assertAll();

    }

}
