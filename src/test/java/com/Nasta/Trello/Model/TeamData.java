package com.Nasta.Trello.Model;

public class TeamData {
    private  String teamName;
    private  String teamDisc;

    public TeamData setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TeamData setTeamDisc(String teamDisc) {
        this.teamDisc = teamDisc;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamDisc() {
        return teamDisc;
    }
}
