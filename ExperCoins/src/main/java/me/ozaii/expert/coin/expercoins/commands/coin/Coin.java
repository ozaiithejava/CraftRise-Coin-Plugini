package me.ozaii.expert.coin.expercoins.commands.coin;
import me.ozaii.expert.coin.expercoins.managers.CoinManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Coin implements CommandExecutor {

    private CoinManager coinManager;

    public Coin(CoinManager coinManager) {
        this.coinManager = coinManager;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("coinim")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int coins = coinManager.getPlayerCoins(player.getName());
                player.sendMessage(ChatColor.GREEN+"Coin sayınız: " +ChatColor.GOLD+ coins);
            } else {
                sender.sendMessage("Bu komut yalnızca oyunda oyuncular tarafından kullanılabilir.");
            }
            return true;
        }
        return false;
    }
}
