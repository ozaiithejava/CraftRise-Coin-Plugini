package me.ozaii.expert.coin.expercoins.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpManager {
    private DatabaseManager databaseManager;
    private LevelManager levelManager;
    public ExpManager(DatabaseManager databaseManager,LevelManager levelManager) {
        this.databaseManager = databaseManager;
        this.levelManager=levelManager;
    }

    public int getPlayerXp(String playerName) {
        int xp = 0;
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("SELECT Xp FROM " + databaseManager.getTableName() + " WHERE Player_name = ?");
            statement.setString(1, playerName);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                xp = result.getInt("Xp");
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xp;
    }


    public void setPlayerXp(String playerName, int xp) {
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("UPDATE " + databaseManager.getTableName() + " SET Xp = ? WHERE Player_name = ?");
            statement.setInt(1, xp);
            statement.setString(2, playerName);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPlayerXp(String playerName, int xpToAdd) {
        int currentXp = getPlayerXp(playerName);
        int updatedXp = currentXp + xpToAdd;
        setPlayerXp(playerName, updatedXp);
    }

    public void removePlayerXp(String playerName, int xpToRemove) {
        int currentXp = getPlayerXp(playerName);
        int updatedXp = Math.max(currentXp - xpToRemove, 0);
        setPlayerXp(playerName, updatedXp);
    }

    public void resetPlayerXp(String playerName) {
        setPlayerXp(playerName, 0);
    }
    public List<String> getTopPlayerXP(int limit) {
        List<String> topPlayers = new ArrayList<>();
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("SELECT Player_name, xp FROM " + databaseManager.getTableName() + " ORDER BY xp DESC LIMIT ?");
            statement.setInt(1, limit);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String playerName = result.getString("Player_name");
                int xp = result.getInt("xp");
                topPlayers.add(playerName + " - XP: " + xp);
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topPlayers;
    }

}

