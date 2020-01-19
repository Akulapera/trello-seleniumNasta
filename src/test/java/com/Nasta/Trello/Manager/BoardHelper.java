package com.Nasta.Trello.Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper  extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//span[@name='board']/..//p"));
    }

    public int getBoardsCount(){
         return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void createBoard() throws InterruptedException {
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("QA-22" + System.currentTimeMillis());
        confirmBoardCreation();
        pause(5000);
        returnToHomePage();
    }

    public boolean isThereBoard() {
        return getBoardsCount() > 1;
    }

    public void openFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[5]"));
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

    public  void deleteBoard(){
        openFirstBoard();
        clickOpenMore();
        startCloseBoard();
        firstConfirmClose();
        secondConfirmDeletion();
        lastConfirmDeletion();
        returnToHomePage();
    }
}
