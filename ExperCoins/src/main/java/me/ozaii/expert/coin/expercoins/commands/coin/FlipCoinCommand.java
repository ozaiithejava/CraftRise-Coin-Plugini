package me.ozaii.expert.coin.expercoins.commands.coin;

import me.ozaii.expert.coin.expercoins.managers.CoinManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class FlipCoinCommand implements CommandExecutor {
    private static final int MIN_COIN_AMOUNT = 20;
    private static final int MAX_COIN_AMOUNT = 1000;
    private static final double WIN_CHANCE = 0.2;
    private CoinManager coinManager;

    public FlipCoinCommand(CoinManager coinManager) {
        this.coinManager = coinManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Bu komutu sadece oyuncular kullanabilir.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Kullanım: /flipcoin <miktar>");
            return true;
        }

        int betAmount;

        try {
            betAmount = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            player.sendMessage(ChatColor.RED + "Geçersiz miktar. Lütfen bir sayı girin.");
            return true;
        }

        if (betAmount < MIN_COIN_AMOUNT || betAmount > MAX_COIN_AMOUNT) {
            player.sendMessage(ChatColor.RED + "Bahis miktarı minimum " + MIN_COIN_AMOUNT + " ve maksimum " + MAX_COIN_AMOUNT + " olmalıdır.");
            return true;
        }

        int playerCoins = coinManager.getPlayerCoins(player.getName());

        if (betAmount > playerCoins) {
            player.sendMessage(ChatColor.RED + "Yeterli coininiz yok.");
            return true;
        }

        Random random = new Random();
        boolean win = random.nextDouble() <= WIN_CHANCE;

        if (win) {
            int winnings = betAmount * 2;
            coinManager.setPlayerCoins(player.getName(), playerCoins + winnings);
            player.sendMessage(ChatColor.GREEN + "Tebrikler! Kazandınız. " + winnings + " coin kazandınız.");
        } else {
            coinManager.setPlayerCoins(player.getName(), playerCoins - betAmount);
            player.sendMessage(ChatColor.RED + "Üzgünüz! Kaybettiniz. " + betAmount + " coin kaybettiniz.");
        }

        return true;
    }
}
