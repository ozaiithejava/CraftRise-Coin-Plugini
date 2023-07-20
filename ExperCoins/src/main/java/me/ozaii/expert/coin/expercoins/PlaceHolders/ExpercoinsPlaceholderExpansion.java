package me.ozaii.expert.coin.expercoins.PlaceHolders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.ozaii.expert.coin.expercoins.Expercoins;
import me.ozaii.expert.coin.expercoins.managers.CoinManager;
import me.ozaii.expert.coin.expercoins.managers.ExpManager;
import me.ozaii.expert.coin.expercoins.managers.LevelManager;
import me.ozaii.expert.coin.expercoins.managers.ProfileManager;
import org.bukkit.OfflinePlayer;

import java.sql.Date;
import java.util.List;

public class ExpercoinsPlaceholderExpansion extends PlaceholderExpansion {
    private Expercoins plugin;
    private CoinManager coinManager;
    private LevelManager levelManager;
    private ExpManager expManager;
    private ProfileManager profileManager;

    public ExpercoinsPlaceholderExpansion(Expercoins plugin, CoinManager coinManager, LevelManager levelManager, ExpManager expManager, ProfileManager profileManager) {
        this.plugin = plugin;
        this.coinManager = coinManager;
        this.levelManager = levelManager;
        this.expManager = expManager;
        this.profileManager = profileManager;
    }

    public String getIdentifier() {
        return "expercoins";
    }

    public String getAuthor() {
        return "ozaii";
    }

    public String getVersion() {
        return this.plugin.getDescription().getVersion();
    }

    public boolean canRegister() {
        return true;
    }

    public boolean persist() {
        return true;
    }

    public String onRequest(OfflinePlayer player, String identifier) {
        if (player == null)
            return "";


        if (identifier.equals("xp")) {
            int xp = expManager.getPlayerXp(player.getName());
            return String.valueOf(xp);
        }

        if (identifier.equals("coin")) {
            int coin = coinManager.getPlayerCoins(player.getName());
            return String.valueOf(coin);
        }

        if (identifier.equals("level")) {
            int coin = levelManager.getPlayerLevel(player.getName());
            return String.valueOf(coin);
        }

        if (identifier.equals("join_date")) {
            Date joinDate = profileManager.getPlayerJoinDate(player.getName());
            return joinDate+"";
        }



        if (identifier.equals("top_coin")) {
            List<String> topPlayers = coinManager.getTopPlayerCoins(10);
            if (topPlayers.isEmpty()) {
                return "";
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < topPlayers.size(); i++) {
                result.append(topPlayers.get(i));
                if (i < topPlayers.size() - 1) {
                    result.append(", ");
                }
            }
            return result.toString();
        }
        if (identifier.equals("top_xp")) {
            List<String> topPlayers = expManager.getTopPlayerXP(10);
            if (topPlayers.isEmpty()) {
                return "";
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < topPlayers.size(); i++) {
                result.append(topPlayers.get(i));
                if (i < topPlayers.size() - 1) {
                    result.append(", ");
                }
            }
            return result.toString();
        }
        if (identifier.equals("top_level")) {
            List<String> topPlayers = levelManager.getTopPlayersLevel(10);
            if (topPlayers.isEmpty()) {
                return "";
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < topPlayers.size(); i++) {
                result.append(topPlayers.get(i));
                if (i < topPlayers.size() - 1) {
                    result.append(", ");
                }
            }
            return result.toString();
        }
        return null;
    }
}
