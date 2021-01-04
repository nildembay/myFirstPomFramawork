package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Test01Locater {

    public Test01Locater(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="searchDropdownBox")
    public WebElement searchDropdown;

    @FindBy(id="twotabsearchtextbox")
    public  WebElement searchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi;

    @FindBy(xpath = "(//div[@class='a-section a-spacing-medium'])[2]")
    public WebElement arananElement;



}
