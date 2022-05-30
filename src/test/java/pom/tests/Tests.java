package pom.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Tests {
    WebDriver driver;

    @BeforeClass
    @Description("setup ")
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.nopcommerce.com/en/demo");
        driver.manage().window().maximize();
    }


    @Severity(SeverityLevel.MINOR)
    @Test(priority=1, description="Verify Logo presence on Home Page")
    @Description("Verify Logo presence on Home Page........")
    @Epic("EP001")
    @Feature("Feature1: Logo")
    @Story("Story:Logo Presence")
    @Step("Verify logo Presence")
    public void logoPresence(){
        boolean dispStatus=driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
        Assert.assertEquals(dispStatus, true);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority=2, description="Verify login")
    @Description("Verify login with Valid Credentials........")
    @Epic("EP001")
    @Feature("Feature2: Login")
    @Story("Story:Valid login")
    @Step("Verify login")
    public void logginTest() throws InterruptedException {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("pavanoltraining@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test@123");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store123");
    }

    @Test(priority=3)
    @Description("  registrationTest")
    public void registrationTest(){

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
