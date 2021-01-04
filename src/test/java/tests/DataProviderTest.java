package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProviderTest {
    @DataProvider
    public static Object[] kelimelistesi() {
        Object[] aranacaklar={"nutella","pencil","tomatoes","samsung"};
        return aranacaklar;
    }

    @Test (dataProvider = "kelimelistesi")
    public void amazonArama(String arananKelimeler) {

        Driver.getDriver().get(ConfigReader.getProperty("page_url"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.searchBox.sendKeys(arananKelimeler+ Keys.ENTER);
        System.out.println(amazonPage.sonucYazisi.getText());
        Driver.closeDriver();
   
    }
}