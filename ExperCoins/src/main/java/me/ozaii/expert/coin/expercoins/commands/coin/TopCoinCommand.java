package me.ozaii.expert.coin.expercoins.commands.coin;

import me.ozaii.expert.coin.expercoins.managers.CoinManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class TopCoinCommand implements CommandExecutor {

    private CoinManager coinManager;

    public TopCoinCommand(CoinManager coinManager) {
        this.coinManager = coinManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("topcoin")) {
            List<String> topPlayers = coinManager.getTopPlayerCoins(10);
            sender.sendMessage(ChatColor.BOLD + "---------------[TOPCOIN]---------------");
            sender.sendMessage(ChatColor.GREEN + "En Yüksek Coin Sahipleri:");

            int rank = 1;
            for (String playerInfo : topPlayers) {
                ChatColor playerNameColor = ChatColor.GOLD;

                if (rank <= 3) {
                    if (rank == 1) {
                        playerNameColor = ChatColor.YELLOW;
                    } else if (rank == 2) {
                        playerNameColor = ChatColor.GREEN;
                    } else if (rank == 3) {
                        playerNameColor = ChatColor.BLUE;
                    }
                }
                sender.sendMessage(playerNameColor + "" + rank + ". " + playerInfo);
                rank++;
            }
            sender.sendMessage(ChatColor.BOLD + "--------------------------------");
            return true;
        }

        return false;
    }
}
