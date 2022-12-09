package steps;

import logpackage.ultilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static logpackage.ultilities.Log.*;

public class StepAction {
    WebDriver driver;

    public StepAction(WebDriver driver){
        this.driver = driver;
    }
    public void clickElement(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).click();
            info("Click element "+xpath);
        }catch (Exception e){
            error("Cannot click element "+xpath);
        }
    }
}
