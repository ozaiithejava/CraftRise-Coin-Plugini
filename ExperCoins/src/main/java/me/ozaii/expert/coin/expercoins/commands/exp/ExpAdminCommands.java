package me.ozaii.expert.coin.expercoins.commands.exp;
import me.ozaii.expert.coin.expercoins.managers.ExpManager;
import me.ozaii.expert.coin.expercoins.managers.LevelManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExpAdminCommands implements CommandExecutor {

    private ExpManager expManager;

    public ExpAdminCommands(ExpManager expManager) {
        this.expManager = expManager;
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

        if (args.length >= 2) {
            String subCommand = args[0];
            String playerName = args[1];

            if (subCommand.equalsIgnoreCase("check")) {
                int xp = expManager.getPlayerXp(playerName);
                player.sendMessage(ChatColor.GREEN + playerName + " adlı oyuncunun deneyim puanı (XP): " +ChatColor.GOLD+ xp);
            } else if (subCommand.equalsIgnoreCase("add")) {
                if (args.length >= 3) {
                    int amount = Integer.parseInt(args[2]);
                    expManager.addPlayerXp(playerName, amount);
                    player.sendMessage(ChatColor.GREEN + playerName + " adlı oyuncuya " +ChatColor.GOLD+ amount +ChatColor.GREEN+ " deneyim puanı (XP) eklendi.");
                } else {
                    player.sendMessage(ChatColor.RED + "Komut kullanımı: /e add <oyuncu_adı> <miktar>");
                }
            } else if (subCommand.equalsIgnoreCase("remove")) {
                if (args.length >= 3) {
                    int amount = Integer.parseInt(args[2]);
                    expManager.removePlayerXp(playerName, amount);
                    player.sendMessage(ChatColor.GREEN + playerName + " adlı oyuncudan " +ChatColor.GOLD+ amount +ChatColor.RED+ " deneyim puanı (XP) çıkarıldı.");
                } else {
                    player.sendMessage(ChatColor.RED + "Komut kullanımı: /e remove <oyuncu_adı> <miktar>");
                }
            } else if (subCommand.equalsIgnoreCase("reset")) {
                expManager.resetPlayerXp(playerName);
                player.sendMessage(ChatColor.GREEN + playerName + ChatColor.RED+" adlı oyuncunun deneyim puanı (XP) sıfırlandı.");
            } else {
                player.sendMessage(ChatColor.RED + "Geçersiz bir alt komut girdiniz.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Komut kullanımı: /e <altkomut> <oyuncu_adı> [miktar]");
        }

        return true;
    }
}
