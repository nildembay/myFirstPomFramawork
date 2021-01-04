package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="searchDropdownBox")
    public WebElement searchDropdown;

    @FindBy(id="twotabsearchtextbox")
    public  WebElement searchBox;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    public List<WebElement> fiyatlistesitamkisim;

    @FindBy(xpath = "//span[@class='a-price-fraction']")
    public List<WebElement> fiyatlistesiondalikkisim;

    @FindBy (xpath = "(//img[@class='s-image'])[1]")
    public WebElement urun;

    @FindBy(id="add-to-cart-button")
    public WebElement sepeteEkle;

    @FindBy(className = "a-button-input")
    public WebElement cartbutonu;

    @FindBy(className = "sc-product-image")
    public WebElement sepettekiUrun;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi;



}
