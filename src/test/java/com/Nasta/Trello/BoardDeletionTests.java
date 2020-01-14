package com.Nasta.Trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.testLogInOldAcc();
        }
        if (!app.isThereBoard()) {
            app.createBoard();
        }
    }
 @Test
    public  void  testBoardDeletion(){
      app.openFirstBoard();
      app.clickOpenMore();
      app.startCloseBoard();
      app.firstConfirmClose();
      app.secondConfirmDeletion();
      app.lastConfirmDeletion();
      app.returnToHomePage();
    }
}