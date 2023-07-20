package me.ozaii.expert.coin.expercoins.commands.coin;

import me.ozaii.expert.coin.expercoins.managers.CoinManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CoinYollaCommand implements CommandExecutor {
    private static final int MIN_COIN_AMOUNT = 10;
    private static final int MAX_COIN_AMOUNT = 100;
    private static final long COOLDOWN_DURATION = 3_600_000;  // 1 saat = 60 dakika * 60 saniye * 1000 milisaniye
    private CoinManager coinManager;
    private Map<String, Long> cooldowns;

    public CoinYollaCommand(CoinManager coinManager) {
        this.coinManager = coinManager;
        this.cooldowns = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Bu komutu yalnızca oyuncular kullanabilir!");
            return true;
        }

        Player player = (Player) sender;
        String playerName = player.getName();

        if (args.length != 2) {
            player.sendMessage(ChatColor.RED + "Kullanım: /coinyolla <oyuncu> <miktar>");
            return true;
        }

        if (hasCooldown(playerName)) {
            player.sendMessage(ChatColor.RED + "Bir dakikadan daha sık coin gönderemezsiniz!");
            return true;
        }

        String targetPlayerName = args[0];
        int amount;

        try {
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            player.sendMessage(ChatColor.RED + "Geçersiz miktar! Lütfen bir tam sayı girin.");
            return true;
        }

        if (amount < MIN_COIN_AMOUNT || amount > MAX_COIN_AMOUNT) {
            player.sendMessage(ChatColor.RED + "Miktar " + MIN_COIN_AMOUNT + " ile " + MAX_COIN_AMOUNT + " arasında olmalıdır!");
            return true;
        }

        boolean success = coinManager.sendPlayerCoins(playerName, targetPlayerName, amount);

        if (success) {
            player.sendMessage(ChatColor.GOLD + ""+amount + ChatColor.GREEN + " coin " + ChatColor.GOLD + targetPlayerName + ChatColor.GREEN + " adlı oyuncuya gönderildi!");
            setCooldown(playerName);
        } else {
            player.sendMessage(ChatColor.RED + "Yeterli coininiz yok veya işlem gerçekleştirilemedi!");
        }

        return true;
    }

    private boolean hasCooldown(String playerName) {
        if (cooldowns.containsKey(playerName)) {
            long lastUsage = cooldowns.get(playerName);
            long currentTime = System.currentTimeMillis();
            return (currentTime - lastUsage) < COOLDOWN_DURATION;
        }
        return false;
    }

    private void setCooldown(String playerName) {
        cooldowns.put(playerName, System.currentTimeMillis());
    }
}
