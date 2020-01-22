package com.Nasta.Trello.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().testLogInOldAcc();
        }
        if (!app.getBoardHelper().isThereBoard()) {
            app.getBoardHelper().createBoard();
        }
    }
 @Test
    public  void  testBoardDeletion(){
      app.getBoardHelper().openFirstBoard();
      app.getBoardHelper().clickOpenMore();
      app.getBoardHelper().startCloseBoard();
      app.getBoardHelper().firstConfirmClose();
      app.getBoardHelper().secondConfirmDeletion();
      app.getBoardHelper().lastConfirmDeletion();
      app.getHeader().returnToHomePage();
    }
}