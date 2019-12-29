package com.Nasta.Trello;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public  void testLoginWithAtlassianAccount () throws InterruptedException {
         clickLoginLink("porokhnia.anastasiya@gmail.com", "495561na");
     }

    @Test
    public  void testLoginWithOldnAccount () throws InterruptedException {
        clickLoginLink("porokhnia.anastasiya@gmail.com", "495561na");
    }

}
