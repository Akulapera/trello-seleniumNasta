package com.Nasta.Trello;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase{

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!isAvatarPresentOnHeader()){
            testLogInOldAcc();
        }
    }
    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = getBoardsCount();
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("QA-22"+ System.currentTimeMillis());
        confirmBoardCreation();
        pause(5000);
        returnToHomePage();
        int actualRes = getBoardsCount();
       int expectedRes= before;
       Assert.assertEquals(actualRes, expectedRes+1);
    }
     @AfterClass
     public  void postActions(){
        int boardCount= getBoardsCount();
        while (boardCount>6){
            deleteBoard();
            boardCount=getBoardsCount();
        }
     }
}


