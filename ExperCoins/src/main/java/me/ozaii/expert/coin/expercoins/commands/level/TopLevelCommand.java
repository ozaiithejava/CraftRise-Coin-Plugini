package me.ozaii.expert.coin.expercoins.commands.level;

import me.ozaii.expert.coin.expercoins.managers.LevelManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class TopLevelCommand implements CommandExecutor {

    private LevelManager levelManager;

    public TopLevelCommand(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("toplevel")) {
            List<String> topPlayers = levelManager.getTopPlayersLevel(10);
            sender.sendMessage(ChatColor.BOLD + "---------------[TOPLEVEL]---------------");
            sender.sendMessage(ChatColor.GREEN + "En Yüksek Seviyeye Sahip Oyuncular:");

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
