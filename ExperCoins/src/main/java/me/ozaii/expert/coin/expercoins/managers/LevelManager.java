package me.ozaii.expert.coin.expercoins.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    private DatabaseManager databaseManager;
    private int maxLevel;
    private int minLevel;

    public LevelManager(DatabaseManager databaseManager, int maxLevel, int minLevel) {
        this.databaseManager = databaseManager;
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
    }

    public int getPlayerLevel(String playerName) {
        int level = minLevel;
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("SELECT level FROM " + databaseManager.getTableName() + " WHERE player_name = ?");
            statement.setString(1, playerName);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                level = Math.max(minLevel, Math.min(maxLevel, result.getInt("level")));
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return level;
    }

    public void setPlayerLevel(String playerName, int level) {
        level = Math.max(minLevel, Math.min(maxLevel, level));
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("UPDATE " + databaseManager.getTableName() + " SET level = ? WHERE player_name = ?");
            statement.setInt(1, level);
            statement.setString(2, playerName);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPlayerLevel(String playerName, int levelsToAdd) {
        int currentLevel = getPlayerLevel(playerName);
        int newLevel = Math.max(minLevel, Math.min(maxLevel, currentLevel + levelsToAdd));
        setPlayerLevel(playerName, newLevel);
    }

    public void resetPlayerLevel(String playerName) {
        setPlayerLevel(playerName, minLevel);
    }

    public void removePlayerLevel(String playerName, int levelsToRemove) {
        int currentLevel = getPlayerLevel(playerName);
        int newLevel = Math.max(minLevel, Math.min(maxLevel, currentLevel - levelsToRemove));
        setPlayerLevel(playerName, newLevel);
    }

    public List<String> getTopPlayersLevel(int limit) {
        List<String> topPlayers = new ArrayList<>();
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("SELECT player_name, level FROM " + databaseManager.getTableName() + " ORDER BY level DESC LIMIT ?");
            statement.setInt(1, limit);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String playerName = result.getString("player_name");
                int level = Math.max(minLevel, Math.min(maxLevel, result.getInt("level")));
                topPlayers.add(playerName + " - Level: " + level);
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topPlayers;
    }
}

