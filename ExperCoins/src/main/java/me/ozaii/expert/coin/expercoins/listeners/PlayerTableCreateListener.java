package me.ozaii.expert.coin.expercoins.listeners;

import me.ozaii.expert.coin.expercoins.managers.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.Date;
import java.time.LocalDate;

public class PlayerTableCreateListener implements Listener {
    private CoinManager coinManager;
    private LevelManager levelManager;
    private ExpManager expManager;
    private ProfileManager profileManager;
    private DatabaseManager databaseManager;

    public PlayerTableCreateListener(DatabaseManager databaseManager, CoinManager coinManager, LevelManager levelManager, ExpManager expManager, ProfileManager profileManager) {
        this.coinManager = coinManager;
        this.levelManager = levelManager;
        this.expManager = expManager;
        this.profileManager = profileManager;
        this.databaseManager = databaseManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        // Tabloda oyuncunun olup olmadığını kontrol et
        boolean playerExists = databaseManager.playerExists(playerName);

        // Oyuncu tabloda yoksa yeni kayıt oluştur
        if (!playerExists) {
            LocalDate currentDate = LocalDate.now();
            Date joinDate = Date.valueOf(currentDate.toString());
            profileManager.setPlayerJoinDate(playerName, joinDate);
            levelManager.setPlayerLevel(playerName, 1);
            // Coin ve XP değerlerini ayarla
            coinManager.setPlayerCoins(playerName, 10);
            expManager.setPlayerXp(playerName, 10);
            Bukkit.getConsoleSender().sendMessage(playerName + " adlı oyuncuyu tabloya kaydettim");
        } else {
            Bukkit.getConsoleSender().sendMessage(playerName + " adlı oyuncu zaten tabloda kayıtlı");
        }
    }


}
