package com.Nasta.Trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {


    WebDriver wd;

    @BeforeClass
    public  void setUp(){
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    public void login(String login, String password) throws InterruptedException {
        clickCSS("[href='/login']");
        type(By.id("user"), login);


        if (wd.findElement(By.id ("password")).isDisplayed()) {
            type(By.id("password"), password);
        }
        clickId(By.id ("login"));

        if (isElementPresent(By.id ("login-submit"))) {
            clickId(By.id ("login-submit"));
            type(By.id ("password"), "495561na");
            clickId(By.id ("login-submit"));
        }

    }

    private void clickCSS(String cssLocator) {
        wd.findElement(By.cssSelector(cssLocator)).click();
    }

    private void clickId(By locator) {

        wd.findElement(locator).click();
    }

    private void type(By locator, String text) {
        clickId(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public  boolean  isElementPresent(By locator)
    {
        return wd.findElements(locator).size()>0;
     }

      @AfterClass
    public  void tearDown (){
        wd.quit();
      }
}

