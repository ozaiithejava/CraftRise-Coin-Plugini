package me.ozaii.expert.coin.expercoins.commands.exp;

import me.ozaii.expert.coin.expercoins.managers.ExpManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExpCommands implements CommandExecutor {

    private ExpManager expManager;

    public ExpCommands(ExpManager expManager) {
        this.expManager = expManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("expim")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int level = expManager.getPlayerXp(player.getName());
                sender.sendMessage(ChatColor.GREEN+"Expiniz: " +ChatColor.GOLD+ level);
            } else {
                sender.sendMessage("Bu komutu yalnızca oyuncular kullanabilir.");
            }
            return true;
        }
        return false;
    }
}
