package com.Nasta.Trello.Tests;
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
        int before = app.getBoardHelper().getBoardsCount();
        app.clickOnPlusButton();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardForm("QA-22"+ System.currentTimeMillis());
        app.getBoardHelper().confirmBoardCreation();
        app.pause(15000);
        app.returnToHomePage();
        int actualRes = app.getBoardHelper().getBoardsCount();
       int expectedRes= before;
       Assert.assertEquals(actualRes, expectedRes+1);
    }
     @AfterClass
     public  void postActions(){
        int boardCount= app.getBoardHelper().getBoardsCount();
        while (boardCount>6){
            app.getBoardHelper().deleteBoard();
            boardCount= app.getBoardHelper().getBoardsCount();
        }
     }
}

