package com.Nasta.Trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests  extends  TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            testLogInOldAcc();
        }
    }

       @Test
    public  void teamCreationFromHeaderTest(){
        clickOnPlusButton();
        selectCreateTeamFromDropDown();
        fillTeamFormCreation("team1", "all of my first team are here");
        submitTeamCreation();
        closeWindowInviteToTeam();
           Assert.assertTrue(isElementPresent(By.cssSelector("[href='/gbf21/home']")));
       }

    private void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }


    public  void   selectCreateTeamFromDropDown(){
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }
     public  void   fillTeamFormCreation(String teamName, String teamDisc){
         type(By.cssSelector("[data-test-id='header-create-team-name-input']"),teamName);
         type(By.cssSelector("._15aIJYNKhrO4vB"),teamDisc);
     }
     public  void closeWindowInviteToTeam(){
        click(By.cssSelector(".qb90FI2uVIybRy "));
     }
}
