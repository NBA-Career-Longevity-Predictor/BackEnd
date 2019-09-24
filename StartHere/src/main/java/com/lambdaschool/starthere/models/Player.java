package com.lambdaschool.starthere.models;

public class Player {
    private long  id;
    private String name;
    private String team;
    private int years;
    private int games;
    private int minutesplayed;
    private int points;
    private int assists;
    private double fieldgoalpercentage;
    private double minutespergame;
    private double pointspergame;
    private double assistspergame;

    public Player() {
    }

    public Player(long id, String name, String team, int years, int games, int minutesplayed, int points, int assists, double fieldgoalpercentage, double minutespergame, double pointspergame, double assistspergame) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.years = years;
        this.games = games;
        this.minutesplayed = minutesplayed;
        this.points = points;
        this.assists = assists;
        this.fieldgoalpercentage = fieldgoalpercentage;
        this.minutespergame = minutespergame;
        this.pointspergame = pointspergame;
        this.assistspergame = assistspergame;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getMinutesplayed() {
        return minutesplayed;
    }

    public void setMinutesplayed(int minutesplayed) {
        this.minutesplayed = minutesplayed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public double getFieldgoalpercentage() {
        return fieldgoalpercentage;
    }

    public void setFieldgoalpercentage(double fieldgoalpercentage) {
        this.fieldgoalpercentage = fieldgoalpercentage;
    }

    public double getMinutespergame() {
        return minutespergame;
    }

    public void setMinutespergame(double minutespergame) {
        this.minutespergame = minutespergame;
    }

    public double getPointspergame() {
        return pointspergame;
    }

    public void setPointspergame(double pointspergame) {
        this.pointspergame = pointspergame;
    }

    public double getAssistspergame() {
        return assistspergame;
    }

    public void setAssistspergame(double assistspergame) {
        this.assistspergame = assistspergame;
    }
}
