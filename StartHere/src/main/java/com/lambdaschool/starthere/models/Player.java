package com.lambdaschool.starthere.models;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Player {
    //ec2-174-129-231-100.compute-1.amazonaws.com

    private final String url = "jdbc:postgresql://ec2-174-129-231-100.compute-1.amazonaws.com:5432/de7hs641qkl8lj";
    private final String user = "pvlzqlvyjrtgur";
    private final String password = "6319504f04fc4fce4775d0ee79c01c456e4e16767c646c929c69bd525d2685db";

    private long playerid;

    private String player;
    private int all_nba;
    private int all_star;
    private int draft_year;
    private int pk;
    private String team;
    private String college;
    private int yrs;
    private int games;
    private int minutes_played;
    private int pts;
    private int trb;
    private int ast;
    private double fg_percentage;
    private double tp_percentage;
    private double ft_percentage;
    private double minutes_per_game;
    private double points_per_game;
    private double assits_per_game;
    private double trb_per_game;
    private int win_share;
    private double ws_per_game;
    private double bpm;
    private double vorp;
    private int attend_college;



    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public Player(){


    }

    public Player(int playerid, String player, int all_nba, int all_star, int draft_year, int pk, String team, String college, int yrs, int games, int minutes_played, int pts, int trb, int ast, double fg_percentage, double tp_percentage, double ft_percentage, double minutes_per_game, double points_per_game, double assits_per_game, double trb_per_game, int win_share, double ws_per_game, double bpm, double vorp, int attend_college) {
        this.playerid = playerid;
        this.player = player;
        this.all_nba = all_nba;
        this.all_star = all_star;
        this.draft_year = draft_year;
        this.pk = pk;
        this.team = team;
        this.college = college;
        this.yrs = yrs;
        this.games = games;
        this.minutes_played = minutes_played;
        this.pts = pts;
        this.trb = trb;
        this.ast = ast;
        this.fg_percentage = fg_percentage;
        this.tp_percentage = tp_percentage;
        this.ft_percentage = ft_percentage;
        this.minutes_per_game = minutes_per_game;
        this.points_per_game = points_per_game;
        this.assits_per_game = assits_per_game;
        this.trb_per_game = trb_per_game;
        this.win_share = win_share;
        this.ws_per_game = ws_per_game;
        this.bpm = bpm;
        this.vorp = vorp;
        this.attend_college = attend_college;
    }

    public void getPlayers() {

        String SQL = "SELECT * FROM players_nba";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            displayPlayers(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }



    private void displayPlayers(ResultSet rs) throws SQLException {
        while (rs.next()) {
                     setPlayerid(Integer.parseInt(rs.getString("unnamed_0")));
                     setPlayer(rs.getString("player"));
                     setTeam(rs.getString("team"));
                     setAll_nba(Integer.parseInt(rs.getString("all_nba")));
                     setAll_star(Integer.parseInt(rs.getString("all_star")));
                     setDraft_year(Integer.parseInt(rs.getString("draft_yr")));
                     setPk(Integer.parseInt(rs.getString("pk")));
                     setCollege(rs.getString("college"));
                     setYrs(Integer.parseInt(rs.getString("yrs")));
                     setGames(Integer.parseInt(rs.getString("games")));
                     setMinutes_played(Integer.parseInt(rs.getString("minutes_played")));
                     setPts(Integer.parseInt(rs.getString("pts")));
                     setTrb(Integer.parseInt(rs.getString("trb")));
                     setAst(Integer.parseInt(rs.getString("ast")));
                     setFg_percentage(Double.parseDouble(rs.getString("fg_percentage")));
                     setTp_percentage(Double.parseDouble(rs.getString("tp_percentage")));
                     setFt_percentage(Double.parseDouble(rs.getString("ft_percentage")));
                     setMinutes_per_game(Double.parseDouble(rs.getString("minutes_per_game")));
                     setPoints_per_game(Double.parseDouble(rs.getString("points_per_game")));
                     setTrb_per_game(Double.parseDouble(rs.getString("trb_per_game")));
                     setAssits_per_game(Double.parseDouble(rs.getString("assits_per_game")));
                     setWin_share(Integer.parseInt(rs.getString("win_share")));
                     setWs_per_game(Double.parseDouble(rs.getString("ws_per_game")));
                     setBpm(Double.parseDouble(rs.getString("bpm")));
                     setVorp(Double.parseDouble(rs.getString("vorp")));
                     setAttend_college(Integer.parseInt(rs.getString("attend_college")));

        }
    }


    public void findPlayersByName(String name) {
        String SQL = "SELECT * "
                + "FROM players_nba "
                + "WHERE player= ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            displayPlayers(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public double getAssits_per_game() {
        return assits_per_game;
    }

    public void setAssits_per_game(double assits_per_game) {
        this.assits_per_game = assits_per_game;
    }

    public long getPlayerid() {
        return playerid;
    }

    public void setPlayerid(long playerid) {
        this.playerid = playerid;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getAll_nba() {
        return all_nba;
    }

    public void setAll_nba(int all_nba) {
        this.all_nba = all_nba;
    }

    public int getAll_star() {
        return all_star;
    }

    public void setAll_star(int all_star) {
        this.all_star = all_star;
    }

    public int getDraft_year() {
        return draft_year;
    }

    public void setDraft_year(int draft_year) {
        this.draft_year = draft_year;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getYrs() {
        return yrs;
    }

    public void setYrs(int yrs) {
        this.yrs = yrs;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getMinutes_played() {
        return minutes_played;
    }

    public void setMinutes_played(int minutes_played) {
        this.minutes_played = minutes_played;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getTrb() {
        return trb;
    }

    public void setTrb(int trb) {
        this.trb = trb;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public double getFg_percentage() {
        return fg_percentage;
    }

    public void setFg_percentage(double fg_percentage) {
        this.fg_percentage = fg_percentage;
    }

    public double getTp_percentage() {
        return tp_percentage;
    }

    public void setTp_percentage(double tp_percentage) {
        this.tp_percentage = tp_percentage;
    }

    public double getFt_percentage() {
        return ft_percentage;
    }

    public void setFt_percentage(double ft_percentage) {
        this.ft_percentage = ft_percentage;
    }

    public double getMinutes_per_game() {
        return minutes_per_game;
    }

    public void setMinutes_per_game(double minutes_per_game) {
        this.minutes_per_game = minutes_per_game;
    }

    public double getPoints_per_game() {
        return points_per_game;
    }

    public void setPoints_per_game(double points_per_game) {
        this.points_per_game = points_per_game;
    }

    public double getTrb_per_game() {
        return trb_per_game;
    }

    public void setTrb_per_game(double trb_per_game) {
        this.trb_per_game = trb_per_game;
    }

    public int getWin_share() {
        return win_share;
    }

    public void setWin_share(int win_share) {
        this.win_share = win_share;
    }

    public double getWs_per_game() {
        return ws_per_game;
    }

    public void setWs_per_game(double ws_per_game) {
        this.ws_per_game = ws_per_game;
    }

    public double getBpm() {
        return bpm;
    }

    public void setBpm(double bpm) {
        this.bpm = bpm;
    }

    public double getVorp() {
        return vorp;
    }

    public void setVorp(double vorp) {
        this.vorp = vorp;
    }

    public int getAttend_college() {
        return attend_college;
    }

    public void setAttend_college(int attend_college) {
        this.attend_college = attend_college;
    }

    public void findPlayersByID(int ID) {
        String SQL = "SELECT * "
                + "FROM players_nba "
                + "WHERE unnamed_0= ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();
            displayPlayers(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


}