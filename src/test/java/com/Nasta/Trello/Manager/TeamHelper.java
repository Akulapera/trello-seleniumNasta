package com.Nasta.Trello.Manager;

import com.Nasta.Trello.Model.TeamData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends  HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public  void   selectCreateTeamFromDropDown(){
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public  void   fillTeamFormCreation(TeamData teamData){
         type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamData.getTeamName());
         type(By.cssSelector("._15aIJYNKhrO4vB"), teamData.getTeamDisc());
     }

    public  void closeWindowInviteToTeam(){
        click(By.cssSelector(".qb90FI2uVIybRy "));
     }

    public  int getTeamsCount(){
      return  wd.findElements(By.cssSelector("[data-test-id^='home-team-tab-section']")).size();
      }
}
