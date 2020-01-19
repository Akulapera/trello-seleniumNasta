package com.Nasta.Trello.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().testLogInOldAcc();
        }
    }

    @Test
    public void teamCreationFromHeaderTest() {
        int teamCountBefore = app.getTeam().getTeamsCount();
        app.getSession().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamFormCreation("team1", "all of my first team are here");
        app.getTeam().submitTeamCreation();
        app.getTeam().closeWindowInviteToTeam();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }
}
