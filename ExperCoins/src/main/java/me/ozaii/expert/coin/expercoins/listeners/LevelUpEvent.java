package me.ozaii.expert.coin.expercoins.listeners;

import me.ozaii.expert.coin.expercoins.managers.ExpManager;
import me.ozaii.expert.coin.expercoins.managers.LevelManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class LevelUpEvent implements Listener {
    private Plugin plugin;
    private ExpManager expManager;
    private LevelManager levelManager;

    public LevelUpEvent(Plugin plugin, ExpManager expManager, LevelManager levelManager) {
        this.plugin = plugin;
        this.expManager = expManager;
        this.levelManager = levelManager;
        startLevelUpTask();
    }

    private void startLevelUpTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : plugin.getServer().getOnlinePlayers()) {
                    updateAutomaticPlayerLevel(player.getName(), 1);
                }
            }
        }.runTaskTimer(plugin, 20L, 20L); // Her saniye gerçekleşecek şekilde ayarlayın (20L = 1 saniye)
    }

    public void updateAutomaticPlayerLevel(String playerName, int level) {
        int xpAmount = expManager.getPlayerXp(playerName);
        if (xpAmount >= 100) {
            expManager.resetPlayerXp(playerName);
            levelManager.addPlayerLevel(playerName, 1);
            Player player = plugin.getServer().getPlayer(playerName);
            if (player != null) {
                player.sendMessage(ChatColor.GREEN + "Tebrikler! Level Atladınız");
                player.sendMessage(ChatColor.GREEN+"Yeni Seviyen: "+ChatColor.GOLD+""+levelManager.getPlayerLevel(player.getName()));
            }
        }
    }

    @EventHandler
    public void onPlayerCheckLevel(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        updateAutomaticPlayerLevel(player.getName(), 1);
    }
}
