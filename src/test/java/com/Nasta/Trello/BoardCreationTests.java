package com.Nasta.Trello;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase{

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.isAvatarPresentOnHeader()){
            app.testLogInOldAcc();
        }
    }
    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = app.getBoardsCount();
        app.clickOnPlusButton();
        app.selectCreateBoardFromDropDown();
        app.fillBoardForm("QA-22"+ System.currentTimeMillis());
        app.confirmBoardCreation();
        app.pause(5000);
        app.returnToHomePage();
        int actualRes = app.getBoardsCount();
       int expectedRes= before;
       Assert.assertEquals(actualRes, expectedRes+1);
    }
     @AfterClass
     public  void postActions(){
        int boardCount= app.getBoardsCount();
        while (boardCount>6){
            app.deleteBoard();
            boardCount= app.getBoardsCount();
        }
     }
}


