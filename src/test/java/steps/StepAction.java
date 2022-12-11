package steps;


import dataHelper.DataHelper;
import logpackage.ultilities.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class StepAction {
    WebDriver driver;
    DataHelper dataHelper = new DataHelper();
    Properties prop = new Properties();

    public StepAction(WebDriver driver) {
        this.driver = driver;
    }

    //    public void login_to_app(){
//        try{
//            driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.username_tb"))).sendKeys(prop.getProperty("username"));
//            driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.password_tb"))).sendKeys(prop.getProperty("password"));
//            driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.login_btn"))).click();
//            Assert.assertTrue(driver.findElement(By.xpath(this.dataHelper.getLocatorsData("Vibelogo"))).isDisplayed());
//            Log.info("Login to app successfully..!!");
//        }catch (Exception e){
//            Log.error("Login to app fail...!");
//            Assert.assertTrue(false);
//        }
//    }
    public void clickElement(String locatorPath) throws IOException {
        String xpath = this.dataHelper.getLocatorsData(locatorPath);
        try {
            driver.findElement(By.xpath(xpath)).click();
            Log.info("Click element " + locatorPath);
        } catch (Exception e) {
            Log.error("Cannot click element " + locatorPath + " with xpath = " + xpath);
            Assert.assertTrue(false);
        }
    }

    public void inputText(String text, String locatorPath) throws IOException {
        String xpath = this.dataHelper.getLocatorsData(locatorPath);
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(text);
            Log.info("Input text " + text + " to " + locatorPath);
        } catch (Exception e) {
            Log.error("Fail to input text " + text + " to " + locatorPath+ " "+xpath);
            Assert.assertTrue(false);
        }
    }

    public void canSeeElement(String locatorPath) throws IOException {
        String xpath = this.dataHelper.getLocatorsData(locatorPath);
        try {
            Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
            Log.info("Can see element " + locatorPath);
        } catch (Exception e) {
            Log.error("Cannot see element " + locatorPath+ " "+xpath);
            Assert.assertTrue(false);
        }
    }
    public void canSeeText(String text) {
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
            Log.info("Can see text " + text);
        } catch (Exception e) {
            Log.error("Cannot see text " + text);
            Assert.assertTrue(false);
        }
    }
    public void canNotSeeText(String text) throws IOException{
        String xpath = "//*[text()='"+text+"']";
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
            if (driver.findElement(By.xpath(xpath)).isDisplayed()){
                Log.error("Should not display text "+text);
                Assert.assertTrue(false);
            }
//            Log.info("Checking for loading");
//            Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
//            Log.info("Can see text " + text);
        } catch (Exception e) {
            Log.info("Cannot see text " + text);
//            Assert.assertTrue(false);
        }
    }
    public void waitUntilElementComplete(String locatorPath) throws IOException {
        String xpath = this.dataHelper.getLocatorsData(locatorPath);
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            Log.info("Checking for loading");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
        }catch(TimeoutException | NoSuchElementException e){
            Log.info("No loading element detected");
        }catch(Exception e2){
            Log.error("Cannot see element "+locatorPath+" "+xpath);
            Assert.assertTrue(false);
        }
        try{
            if (driver.findElement(By.xpath(xpath)).isDisplayed()){
                Log.info("Loading has detected");
                WebDriverWait wait = new WebDriverWait(driver,20);
                wait.until(ExpectedConditions.invisibilityOf((driver.findElement(By.xpath(xpath)))));
                Log.info("Loading completed!");
            }
        }catch(TimeoutException | NoSuchElementException e3){
            Log.error("Loading too long!");
            Assert.assertTrue(false);
        }catch(Exception e4){
            Log.error("Loading too long!");
            Assert.assertTrue(false);
        }
    }
}