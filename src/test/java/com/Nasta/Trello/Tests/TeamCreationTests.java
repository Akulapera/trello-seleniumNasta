package com.Nasta.Trello.Tests;

import com.Nasta.Trello.Model.TeamData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTests extends TestBase {

    @DataProvider
    public Iterator <Object[]> validTeams(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{"nameDPro ", "decxDPro "});
        list.add(new Object[]{"DPN", ""});
        list.add(new Object[]{"Dййй", "ййййййй"});
        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> validTeamsCSV() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader("src/test/resources/team.csv"));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]
                    {new TeamData()
                            .setTeamName(split[0])
                            .setTeamDisc(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

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
    @Test(dataProvider="validTeams")
    public void teamCreationFromHeaderTestWithDP(String teamName, String teamDisc) {
        int teamCountBefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamFormCreation(new TeamData().
                setTeamName(teamName).
                setTeamDisc(teamDisc));
        app.getTeam().submitTeamCreation();
        app.getTeam().closeWindowInviteToTeam();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }

    @Test(dataProvider="validTeamsCSV")
    public void teamCreationFromHeaderTestCSV(TeamData team) {
        int teamCountBefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamFormCreation(team);
        app.getTeam().submitTeamCreation();
        app.getTeam().closeWindowInviteToTeam();
        int teamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(teamCountAfter, teamCountBefore + 1);
    }
}
