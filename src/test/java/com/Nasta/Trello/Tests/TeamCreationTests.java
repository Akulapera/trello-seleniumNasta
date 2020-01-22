package com.Nasta.Trello.Tests;

import com.Nasta.Trello.Model.TeamData;
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
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamFormCreation(new TeamData().
                        setTeamName("team1").
                        setTeamDisc("all of my first team are here"));
        app.getTeam().submitTeamCreation();
        app.getTeam().closeWindowInviteToTeam();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }
    @Test
    public void teamCreationFromHeaderTestWithNameOnly() {
        int teamCountBefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamFormCreation(new TeamData().
                setTeamName("teamNameOnly"));
        app.getTeam().submitTeamCreation();
        app.getTeam().closeWindowInviteToTeam();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }
}
