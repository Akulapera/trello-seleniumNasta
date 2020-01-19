package com.Nasta.Trello.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.testLogInOldAcc();
        }
    }

    @Test
    public void teamCreationFromHeaderTest() {
        int teamCountBefore = app.getTeamsCount();
        app.clickOnPlusButton();
        app.selectCreateTeamFromDropDown();
        app.fillTeamFormCreation("team1", "all of my first team are here");
        app.submitTeamCreation();
        app.closeWindowInviteToTeam();
        int teamCountAfter = app.getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }
}
