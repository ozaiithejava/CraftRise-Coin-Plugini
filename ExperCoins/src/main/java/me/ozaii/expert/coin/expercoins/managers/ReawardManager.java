package me.ozaii.expert.coin.expercoins.managers;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ReawardManager {
    private ActionBarAPI actionBarAPI;
    private CoinManager coinManager;
    private ExpManager expManager;

    public ReawardManager(CoinManager coinManager,ExpManager expManager){
        this.coinManager=coinManager;
        this.expManager=expManager;
    }
    public void getKillReward(Player playerName, int amount) {
        coinManager.addPlayerCoins(playerName.getName(), amount);
        expManager.addPlayerXp(playerName.getName(), amount);
        actionBarAPI.sendActionBar(playerName, ChatColor.GREEN +"[XP:]"+ChatColor.BOLD+ String.valueOf(amount) + "|" + ChatColor.GOLD +"[COIN:]"+ChatColor.BOLD+ String.valueOf(amount));
    }
    public void getWonReward(Player playerName, int amount) {
        coinManager.addPlayerCoins(playerName.getName(), amount);
        expManager.addPlayerXp(playerName.getName(), amount);
        actionBarAPI.sendActionBar(playerName, ChatColor.GREEN +"[XP:]"+ChatColor.BOLD+ String.valueOf(amount) + "|" + ChatColor.GOLD +"[COIN:]"+ChatColor.BOLD+ String.valueOf(amount));
    }
    public void getNegativeReaward(Player playerName, int amount) {
        coinManager.removePlayerCoins(playerName.getName(), amount);
        expManager.removePlayerXp(playerName.getName(), amount);
        actionBarAPI.sendActionBar(playerName, ChatColor.GREEN +"[XP:]"+ChatColor.BOLD+ String.valueOf(amount) + "|" + ChatColor.GOLD +"[COIN:]"+ChatColor.BOLD+ String.valueOf(amount)+ChatColor.RED+"KAYEBTTIN!");
    }
}
