package com.Nasta.Trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AnotherLoginTest extends TestBase {
    WebDriver wd;

    @BeforeClass
    public  void setUp(){
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

     @Test
    public  void testLoginWithAtlassianAccount () throws InterruptedException {
         clickLoginLink();
     }

    @Test
    public  void testLoginWithOldnAccount () throws InterruptedException {
        clickLoginLink();
    }

    public void clickLoginLink() throws InterruptedException {
        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("porokhnia.anastasiya@gmail.com");
        Thread.sleep(5000);

        if(wd.findElement(By.id("password")).isDisplayed()){
            wd.findElement(By.id("password")).click();
            wd.findElement(By.id("password")).clear();
            wd.findElement(By.id("password")).sendKeys("495561na");
        }
        wd.findElement(By.id("login")).click();

           if (isElementPresent(By.id("login-submit"))){
               wd.findElement(By.id("login-submit")).click();

               wd.findElement(By.id("password")).click();
               wd.findElement(By.id("password")).clear();
               wd.findElement(By.id("password")).sendKeys("495561na");

               wd.findElement(By.id("login-submit")).click();
           }





    }

     public  boolean  isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
     }
}
