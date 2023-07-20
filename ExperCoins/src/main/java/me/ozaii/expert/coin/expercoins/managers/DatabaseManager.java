package me.ozaii.expert.coin.expercoins.managers;

import me.ozaii.expert.coin.expercoins.Expercoins;
import me.ozaii.expert.coin.expercoins.managers.ConfigManager;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;
    private String tableName;
    private Expercoins expercoins;

    public DatabaseManager(Expercoins expercoins, ConfigManager configManager) {
        this.expercoins = expercoins;
        String host = configManager.getString("mysql.host");
        int port = configManager.getInt("mysql.port");
        String database = configManager.getString("mysql.database");
        String username = configManager.getString("mysql.username");
        String password = configManager.getString("mysql.password");
        this.tableName = configManager.getString("mysql.table");

        try {
            String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + database;
            connection = DriverManager.getConnection(connectionString, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public String getTableName() {
        return tableName;
    }

    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "player_name VARCHAR(255) NOT NULL," +
                    "coin INT NOT NULL," +
                    "xp INT NOT NULL," +
                    "status INT NOT NULL," +
                    "joindate DATE NOT NULL," +
                    "level INT NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            statement.close();
            expercoins.getLogger().info("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTable_reawards() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "player_name VARCHAR(255) NOT NULL," +
                    "coin INT NOT NULL," +
                    "xp INT NOT NULL," +
                    "status INT NOT NULL," +
                    "joindate DATE NOT NULL," +
                    "level INT NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            statement.close();
            expercoins.getLogger().info("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean playerExists(String playerName) {
        try {
            PreparedStatement checkStatement = getConnection().prepareStatement("SELECT * FROM " + tableName + " WHERE player_name = ?");
            checkStatement.setString(1, playerName);

            ResultSet result = checkStatement.executeQuery();

            boolean exists = result.next();

            result.close();
            checkStatement.close();

            if (!exists) {
                // Kayıt yoksa yeni kayıt oluştur
                PreparedStatement insertStatement = getConnection().prepareStatement("INSERT INTO " + tableName + " (player_name, coin, xp, status, joindate, level) VALUES (?, 1, 1, 0, CURDATE(), 1)");
                insertStatement.setString(1, playerName);
                insertStatement.executeUpdate();
                insertStatement.close();
            }

            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
