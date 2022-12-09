package steps;

import Base.BaseSetup;
import dataHelper.DataHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import logpackage.ultilities.Log;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
    public void i_login_to_app() throws IOException {
        driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.username_tb"))).sendKeys(prop.getProperty("username"));
        driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.password_tb"))).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath(this.dataHelper.getLocatorsData("loginPage.login_btn"))).click();
//        driver.navigate().to(url);
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @And("^I click element (.+)$")
    public void i_click_element(String locatorPath) throws IOException {
        String xpath = this.dataHelper.getLocatorsData(locatorPath);
        this.stepAction.clickElement(xpath);
//        Thread.sleep(5000);
//        String xpath = dataHelper.getLocatorsData(locatorPath);
//        driver.findElement(By.xpath(xpath));
//        Log.info("Click element "+ xpath);
//        Thread.sleep(5000);
    }


}
