package me.ozaii.expert.coin.expercoins.commands.level;

import me.ozaii.expert.coin.expercoins.managers.LevelManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LevelCommands implements CommandExecutor {
    private LevelManager levelManager;

    public LevelCommands(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("l")) {
            if (args.length >= 3) {
                String subCommand = args[0];
                String playerName = args[1];

                if (subCommand.equalsIgnoreCase("add")) {
                    if (sender.hasPermission("ExperCoin.admin")) {
                        int levelsToAdd = Integer.parseInt(args[2]);
                        levelManager.addPlayerLevel(playerName, levelsToAdd);
                        sender.sendMessage(ChatColor.GREEN+playerName + " adlı oyuncunun seviyesine "+ChatColor.GOLD+ levelsToAdd +ChatColor.GREEN+ " seviye eklendi.");
                    } else {
                        sender.sendMessage("Bu komutu kullanmaya yetkiniz yok.");
                    }
                } else if (subCommand.equalsIgnoreCase("remove")) {
                    if (sender.hasPermission("ExperCoin.admin")) {
                        int levelsToRemove = Integer.parseInt(args[2]);
                        levelManager.removePlayerLevel(playerName, levelsToRemove);
                        sender.sendMessage(ChatColor.GREEN+playerName + " adlı oyuncunun seviyesinden " +ChatColor.GOLD+ levelsToRemove +ChatColor.RED+ " seviye düşürüldü.");
                    } else {
                        sender.sendMessage("Bu komutu kullanmaya yetkiniz yok.");
                    }
                } else if (subCommand.equalsIgnoreCase("reset")) {
                    if (sender.hasPermission("ExperCoin.admin")) {
                        levelManager.resetPlayerLevel(playerName);
                        sender.sendMessage(ChatColor.GREEN+playerName +ChatColor.RED+ " adlı oyuncunun seviyesi sıfırlandı.");
                    } else {
                        sender.sendMessage("Bu komutu kullanmaya yetkiniz yok.");
                    }
                } else if (subCommand.equalsIgnoreCase("check")) {
                    int level = levelManager.getPlayerLevel(playerName);
                    sender.sendMessage(ChatColor.GREEN+playerName + " adlı oyuncunun seviyesi: " +ChatColor.GOLD+ level);
                }
            }else{
                sender.sendMessage(ChatColor.RED+"Yanlış Kullanım: "+" /l <add,remove,reset,check> <oyuncuadı> <miktar veya .>");
            }
        }else{
            sender.sendMessage(ChatColor.RED+"Yanlış Kullanım: "+" /l <add,remove,reset,check> <oyuncuadı> <miktar veya .>");
        }

        return true;
    }
}
