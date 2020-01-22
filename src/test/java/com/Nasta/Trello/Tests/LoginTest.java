package com.Nasta.Trello.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().logout();
        }
    }

    @Test(enabled = false)
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormAtlassianAcc("porokhnia.anastasiya@gmail.com", "495561na");
        app.getHeader().pause(10000);
        Assert.assertTrue
                (app.getSession().isAvatarPresentOnHeader());
    }

    @Test(enabled = false)
    public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormAtlassianAcc("roch", "");
        app.getHeader().pause(8000);
        Assert.assertTrue(app.getSession().isErrorPresent());
        Assert.assertTrue
                (!app.getSession().isAvatarPresentOnHeader());
    }

    @Test
    public void testLogInOldAcc() {
        app.getSession().clickLoginLink();
        app.getSession().fillLoginFormOldAcc("porokhnia.anastasiya@gmail.com", "495561na");
        app.getSession().confirmLogin();
        Assert.assertTrue
                (app.getSession().isAvatarPresentOnHeader());
    }

}
