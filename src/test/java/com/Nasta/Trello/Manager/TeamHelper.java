package com.Nasta.Trello.Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends  HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    protected void submitTeamCreation() {
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

    public  int getTeamsCount(){
      return  wd.findElements(By.cssSelector("[data-test-id^='home-team-tab-section']")).size();
      }
}
