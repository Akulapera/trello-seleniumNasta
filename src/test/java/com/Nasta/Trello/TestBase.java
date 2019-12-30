package com.Nasta.Trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        type("user", login);


        if (wd.findElement(By.id("password")).isDisplayed()) {
            type("password", password);
        }
        clickId("login");

        if (isElementPresent(By.id("login-submit"))) {
            clickId("login-submit");
            type("password", "495561na");
            clickId("login-submit");
        }

    }

    private void clickCSS(String cssLocator) {
        wd.findElement(By.cssSelector(cssLocator)).click();
    }

    private void clickId(String locator) {

        wd.findElement(By.id(locator)).click();
    }

    private void type(String locator, String text) {
        clickId(locator);
        wd.findElement(By.id(locator)).clear();
        wd.findElement(By.id(locator)).sendKeys(text);
    }

    public  boolean  isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
     }
}

