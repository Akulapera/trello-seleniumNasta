package com.Nasta.Trello.Tests;
        import com.Nasta.Trello.Model.BoardData;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase{

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getSession().isAvatarPresentOnHeader()){
            app.getSession().testLogInOldAcc();
        }
    }
    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardForm(new BoardData("iiiiii-22" + System.currentTimeMillis()));
        app.getBoardHelper().confirmBoardCreation();
        app.getHeader().pause(15000);
        app.getHeader().returnToHomePage();
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


