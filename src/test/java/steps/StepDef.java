package steps;

import Base.BaseSetup;
import dataHelper.DataHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import logpackage.ultilities.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StepDef extends BaseSetup {
    WebDriver driver;
    StepAction stepAction;
    DataHelper dataHelper = new DataHelper();
    Properties prop = new Properties();
    InputStream inputStream = null;

    @Before
    public void StartScenario() throws IOException {
        inputStream = new FileInputStream("src/main/resources/config.properties");
        prop.load(inputStream);
        initializeTestBaseSetup(prop.getProperty("browser"),prop.getProperty("appUrl"));
//        System.out.println("Launching Chrome browser...");
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        this.driver = getDriver();
        this.stepAction = new StepAction(this.driver);
    }
    @Given("I login to app")
    public void i_login_to_app() {
//        this.stepAction.login_to_app();
        try{
            driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.username_tb"))).sendKeys(prop.getProperty("username"));
            driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.password_tb"))).sendKeys(prop.getProperty("password"));
            driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.login_btn"))).click();
            Assert.assertTrue(driver.findElement(By.xpath(this.dataHelper.getLocatorsData("Vibelogo"))).isDisplayed());
            Log.info("Login to app successfully..!!");
        }catch (Exception e){
            Log.error("Login to app fail...!");
            Assert.assertTrue(false);
        }
    }

    @And("^I click element (.+)$")
    public void i_click_element(String locatorPath) throws IOException {
        this.stepAction.clickElement(locatorPath);
//        Thread.sleep(5000);
//        String xpath = dataHelper.getLocatorsData(locatorPath);
//        driver.findElement(By.xpath(xpath));
//        Log.info("Click element "+ xpath);
//        Thread.sleep(5000);
    }
    @And("^I input text (.+) to field (.+)$")
    public void i_input_text(String text, String locatorPath) throws IOException {
        this.stepAction.inputText(text, locatorPath);
    }
    @And("^I can see element (.+)$")
    public void can_see_element(String locatorPath) throws IOException {
        this.stepAction.canSeeElement(locatorPath);
    }
    @And("^I can see text (.+)$")
    public void can_see_text(String text) throws IOException {
        this.stepAction.canSeeText(text);
    }
    @And("^I cannot see text (.+)$")
    public void cannot_see_text(String text) throws IOException{
        this.stepAction.canNotSeeText(text);
    }
    @And("^If I see (.+) element I wait until it disappear$")
    public void see_element_wait_until_disappear(String locatorPath) throws IOException {
        this.stepAction.waitUntilElementComplete(locatorPath);
    }
    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Completed test! Close browser");
    }
}
