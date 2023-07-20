package me.ozaii.expert.coin.expercoins.commands.level;

import me.ozaii.expert.coin.expercoins.managers.LevelManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Level implements CommandExecutor {
    private LevelManager levelManager;


    public Level(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("levelim")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int level = levelManager.getPlayerLevel(player.getName());
                sender.sendMessage(ChatColor.GREEN+"Seviyeniz: " +ChatColor.GOLD+ level);
            } else {
                sender.sendMessage("Bu komutu yalnızca oyuncular kullanabilir.");
            }
            return true;
        }
        return false;
    }
}
