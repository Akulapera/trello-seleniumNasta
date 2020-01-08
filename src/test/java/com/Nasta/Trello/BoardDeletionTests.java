package com.Nasta.Trello;

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
}