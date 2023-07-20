package me.ozaii.expert.coin.expercoins.commands.profil;

import me.ozaii.expert.coin.expercoins.managers.CoinManager;
import me.ozaii.expert.coin.expercoins.managers.ExpManager;
import me.ozaii.expert.coin.expercoins.managers.LevelManager;
import me.ozaii.expert.coin.expercoins.managers.ProfileManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileCommands implements CommandExecutor {
    private ProfileManager profileManager;
    private CoinManager coinManager;
    private LevelManager levelManager;
    private ExpManager expManager;

    public ProfileCommands(ProfileManager profileManager, CoinManager coinManager, LevelManager levelManager, ExpManager expManager) {
        this.profileManager = profileManager;
        this.coinManager = coinManager;
        this.levelManager = levelManager;
        this.expManager = expManager;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Bu komut yalnızca oyuncular tarafından kullanılabilir.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("ExperCoin.admin")) {
            player.sendMessage(ChatColor.RED + "Bu komutu kullanmaya yetkiniz yok.");
            return true;
        }

        if (args.length >= 2) {
            String playerName = args[1];

            Date joinDate = profileManager.getPlayerJoinDate(playerName);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String formattedJoinDate = dateFormat.format(joinDate);

            // Coin miktarı
            int coinAmount = coinManager.getPlayerCoins(playerName);

            // Level
            int level = levelManager.getPlayerLevel(playerName);

            // XP
            int xp = expManager.getPlayerXp(playerName);
            player.sendMessage(ChatColor.YELLOW + playerName + " adlı oyuncunun profil bilgileri:");
            player.sendMessage(ChatColor.GREEN+"Katıldığı Tarih: " +ChatColor.GOLD+ formattedJoinDate);
            player.sendMessage(ChatColor.GREEN+"Coin Miktarı: " +ChatColor.GOLD+ coinAmount);
            player.sendMessage(ChatColor.GREEN+"Level: " +ChatColor.GOLD+ level);
            player.sendMessage(ChatColor.GREEN+"XP: "+ChatColor.GOLD+ + xp);
        } else {
            player.sendMessage(ChatColor.RED + "Komut kullanımı: /p check <oyuncu_adı>");
        }

        return true;
    }
}
