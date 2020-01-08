package com.Nasta.Trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            testLogInOldAcc();
        }
        if (!isThereBoard()) {
            createBoard();
        }
    }
 @Test
    public  void  testBoardDeletion(){
      openFirstBoard();
      clickOpenMore();
      startCloseBoard();
      firstConfirmClose();
      secondConfirmDeletion();
      lastConfirmDeletion();
      returnToHomePage();
 }

    public void openFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[2]"));
    }

    public  void clickOpenMore(){
        click(By.cssSelector(".js-open-more"));
    }

    public  void startCloseBoard(){
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']"));
    }
    public  void firstConfirmClose() {
        click(By.cssSelector(".js-confirm"));
    }

    public  void secondConfirmDeletion() {
        click(By.cssSelector(".js-delete"));
    }

    public  void lastConfirmDeletion() {
        click(By.cssSelector("[type=submit]"));
    }
}