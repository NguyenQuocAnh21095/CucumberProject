package steps;

import dataHelper.DataHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import logpackage.ultilities.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StepDef {
    WebDriver driver;
    DataHelper dataHelper = new DataHelper();

    @Before
    public void StartScenario(){
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.driver = driver;
    }
    @Given("^I open url (.+)$")
    public void i_open_url(String url) {
        driver.navigate().to(url);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @And("^I click element (.+)$")
    public void i_click_element(String locatorPath) throws IOException, InterruptedException {
        Thread.sleep(5000);
        String xpath = dataHelper.getLocatorsData(locatorPath);
        driver.findElement(By.xpath(xpath));
        Log.info("Click element "+ xpath);
        Thread.sleep(5000);
    }


}
