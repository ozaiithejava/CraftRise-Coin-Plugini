package me.ozaii.expert.coin.expercoins.managers;

import me.ozaii.expert.coin.expercoins.Expercoins;
import org.bukkit.Bukkit;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CoinManager {

    private Expercoins expercoins;
    private DatabaseManager databaseManager;


    public CoinManager(Expercoins expercoins, DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        this.expercoins = expercoins;
    }

    public int getPlayerCoins(String playerName) {
        int coins = 0;
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("SELECT Coin FROM " + databaseManager.getTableName() + " WHERE Player_name = ?");
            statement.setString(1, playerName);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                coins = result.getInt("Coin");
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coins;
    }

    public void setPlayerCoins(String playerName, int coins) {
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("UPDATE " + databaseManager.getTableName() + " SET Coin = ? WHERE Player_name = ?");
            statement.setInt(1, coins);
            statement.setString(2, playerName);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void resetPlayerCoins(String playerName) {
        setPlayerCoins(playerName, 0);
    }

    public void addPlayerCoins(String playerName, int coinsToAdd) {
        int currentCoins = getPlayerCoins(playerName);
        setPlayerCoins(playerName, currentCoins + coinsToAdd);
    }

    public void removePlayerCoins(String playerName, int coinsToRemove) {
        int currentCoins = getPlayerCoins(playerName);
        int newCoins = Math.max(0, currentCoins - coinsToRemove);
        setPlayerCoins(playerName, newCoins);
    }

    public boolean sendPlayerCoins(String senderName, String receiverName, int coinsToSend) {
        int senderCoins = getPlayerCoins(senderName);
        int receiverCoins = getPlayerCoins(receiverName);

        if (senderCoins >= coinsToSend) {
            setPlayerCoins(senderName, senderCoins - coinsToSend);
            setPlayerCoins(receiverName, receiverCoins + coinsToSend);
            return true;
        }

        return false;
    }


    public List<String> getTopPlayerCoins(int limit) {
        List<String> topPlayers = new ArrayList<>();
        try {
            PreparedStatement statement = databaseManager.getConnection().prepareStatement("SELECT player_name, coin FROM " + databaseManager.getTableName() + " ORDER BY coin DESC LIMIT ?");
            statement.setInt(1, limit);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String playerName = result.getString("player_name");
                int coins = result.getInt("coin");
                topPlayers.add(playerName + " - Coins: " + coins);
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topPlayers;
    }


}

