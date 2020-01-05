package com.Nasta.Trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (isAvatarPresentOnHeader()) {
            logout();
        }
    }

    @Test(enabled = false)
    public void testLogInWithAtlassianAcc() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("porokhnia.anastasiya@gmail.com", "495561na");
        pause(20000);
        Assert.assertTrue
                (isAvatarPresentOnHeader());
    }

    @Test(enabled = false)
    public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
        clickLoginLink();
        fillLoginFormAtlassianAcc("roch", "");
        pause(8000);
        Assert.assertTrue(isErrorPresent());
        Assert.assertTrue
                (!isAvatarPresentOnHeader());
    }

    @Test
    public void testLogInOldAcc() {
        clickLoginLink();
        fillLoginFormOldAcc("porokhnia.anastasiya@gmail.com", "495561na");
        confirmLogin();
        Assert.assertTrue
                (isAvatarPresentOnHeader());
    }

}
