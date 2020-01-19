package com.Nasta.Trello.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.isAvatarPresentOnHeader()) {
            app.logout();
        }
    }

    @Test(enabled = false)
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        app.clickLoginLink();
        app.fillLoginFormAtlassianAcc("porokhnia.anastasiya@gmail.com", "495561na");
        app.pause(20000);
        Assert.assertTrue
                (app.isAvatarPresentOnHeader());
    }

    @Test(enabled = false)
    public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
        app.clickLoginLink();
        app.fillLoginFormAtlassianAcc("roch", "");
        app.pause(8000);
        Assert.assertTrue(app.isErrorPresent());
        Assert.assertTrue
                (!app.isAvatarPresentOnHeader());
    }

    @Test
    public void testLogInOldAcc() {
        app.clickLoginLink();
        app.fillLoginFormOldAcc("porokhnia.anastasiya@gmail.com", "495561na");
        app.confirmLogin();
        Assert.assertTrue
                (app.isAvatarPresentOnHeader());
    }
    public void testLogInOldAcc() throws InterruptedException {
        clickLoginLink();
        fillLoginFormOldAcc("porokhnia.anastasiya@gmail.com", "495561na");
        confirmLogin();
    }
}

}
