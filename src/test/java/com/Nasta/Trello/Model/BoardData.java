package com.Nasta.Trello.Model;

public class BoardData {
    private String boardName;
    String team;

    public BoardData(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }
}
