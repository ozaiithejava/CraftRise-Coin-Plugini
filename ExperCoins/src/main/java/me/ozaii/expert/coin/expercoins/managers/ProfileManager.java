package me.ozaii.expert.coin.expercoins.managers;

import me.ozaii.expert.coin.expercoins.Expercoins;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class ProfileManager {
    private DatabaseManager databaseManager;
    private Expercoins expercoins;

    public ProfileManager(Expercoins expercoins, DatabaseManager databaseManager) {
        this.expercoins = expercoins;
        this.databaseManager = databaseManager;
    }

    public Date getPlayerJoinDate(String playerName) {
        Date joinDate = null;
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("SELECT joindate FROM " + databaseManager.getTableName() + " WHERE Player_name = ?");
            statement.setString(1, playerName);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                joinDate = result.getDate("joindate");
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joinDate;
    }

    public void setPlayerJoinDate(String playerName, Date joinDate) {
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("UPDATE " + databaseManager.getTableName() + " SET joindate = ? WHERE Player_name = ?");
            statement.setDate(1, joinDate);
            statement.setString(2, playerName);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getPlayerStatus(String playerName) {
        int status = 0;
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("SELECT status FROM " + databaseManager.getTableName() + " WHERE Player_name = ?");
            statement.setString(1, playerName);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                status = result.getInt("status");
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void setPlayerStatus(String playerName, int status) {
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("UPDATE " + databaseManager.getTableName() + " SET status = ? WHERE Player_name = ?");
            statement.setInt(1, status);
            statement.setString(2, playerName);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
