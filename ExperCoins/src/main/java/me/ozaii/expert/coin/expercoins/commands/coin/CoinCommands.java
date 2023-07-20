package me.ozaii.expert.coin.expercoins.commands.coin;

import me.ozaii.expert.coin.expercoins.managers.CoinManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinCommands implements CommandExecutor {

    private CoinManager coinManager;

    public CoinCommands(CoinManager coinManager) {
        this.coinManager = coinManager;
    }

    @Override
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

        if (args.length >= 3) {
            String subCommand = args[0];
            String playerName = args[1];

            if (subCommand.equalsIgnoreCase("set")) {
                int amount = Integer.parseInt(args[2]);
                coinManager.setPlayerCoins(playerName, amount);
                player.sendMessage(ChatColor.GREEN+playerName + " adlı oyuncunun coin miktarı " +ChatColor.GOLD+ amount + ChatColor.GREEN+" olarak ayarlandı.");
            } else if (subCommand.equalsIgnoreCase("add")) {
                int amount = Integer.parseInt(args[2]);
                coinManager.addPlayerCoins(playerName, amount);
                player.sendMessage(ChatColor.GREEN+playerName + " adlı oyuncuya " + ChatColor.GOLD+amount + ChatColor.GREEN+" coin eklendi.");
            } else if (subCommand.equalsIgnoreCase("reset")) {
                coinManager.resetPlayerCoins(playerName);
                player.sendMessage(ChatColor.GREEN+playerName +ChatColor.RED+ " adlı oyuncunun coin miktarı sıfırlandı.");
            } else if (subCommand.equalsIgnoreCase("remove")) {
                int amount = Integer.parseInt(args[2]);
                coinManager.removePlayerCoins(playerName, amount);
                player.sendMessage(ChatColor.GREEN+playerName + " adlı oyuncudan " +ChatColor.GOLD+ amount +ChatColor.RED+ " coin çıkarıldı.");
            } else if (subCommand.equalsIgnoreCase("check")) {
                int coins = coinManager.getPlayerCoins(playerName);
                player.sendMessage(ChatColor.GREEN+playerName + " adlı oyuncunun coin miktarı: " +ChatColor.GOLD+ coins);
            } else {
                player.sendMessage(ChatColor.RED + "Geçersiz bir alt komut girdiniz.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Komut kullanımı: /c <altkomut> <oyuncu_adı> <miktar eğer check ise .>");
        }

        return true;
    }
}
