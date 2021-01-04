package crossBrowser;

import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class AmazonTitleUrl extends TestBaseCross {
    @Test
    public void title(){
        driver.get("http://www.amazon.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void url(){
        driver.get("http://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }

}
