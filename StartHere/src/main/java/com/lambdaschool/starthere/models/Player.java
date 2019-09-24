package com.lambdaschool.starthere.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author postgresqltutorial.com
 */
public class Player {

    private final String url = "jdbc:postgresql://localhost/de7hs641qkl8lj";
    private final String user = "pvlzqlvyjrtgur";
    private final String password = "6319504f04fc4fce4775d0ee79c01c456e4e16767c646c929c69bd525d2685db";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @throws java.sql.SQLException
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * Get all rows in the actor table
     */
    public void getPlayers() {

        String SQL = "SELECT * FROM players_nba";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            displayPlayers(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Get actors count
     * @return
     */
//    public int getActorCount() {
//        String SQL = "SELECT count(*) FROM actor";
//        int count = 0;
//
//        try (Connection conn = connect();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(SQL)) {
//            rs.next();
//            count = rs.getInt(1);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return count;
//    }

    /**
     * Display actor
     *
     * @param rs
     * @throws SQLException
     */
    private void displayPlayers(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("unnamed_0") + "\t"
                    + rs.getString("player") + "\t"
                    + rs.getString("team"));

        }
    }

    /**
     * Find actor by his/her ID
     *
     * @param ID
     */
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

    /**
     * @param args the command line arguments
     */
    public static void Player(String[] args) {
        Player player = new Player();
        player.findPlayersByID(1);
    }
}